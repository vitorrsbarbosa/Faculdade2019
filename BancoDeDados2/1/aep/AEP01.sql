/*
Fazer cálculo das parcelas da compra de um carro com várias condições de pagamento
- criar um bloco pl-sql para calcular o valor de cada parcela de uma compra de um carro, nas seguintes condições:
- parcelas para aquisição em 6 pagamentos.
- parcelas para aquisição em 12 pagamentos.
- parcelas para aquisição em 18 pagamentos.
Observação:
1 - o valor da compra deverá ser informado em tempo de execução.
2 - deverá ser dada uma entrada de 20% do valor da compra.
3 - deverá ser aplicada uma taxa juros, no saldo restante, nas seguintes condições:
a - pagamento em 6 parcelas: 10%.
b - pagamento em 12 parcelas: 15%.
c - pagamento em 18 parcelas: 20%.
4 - no final informar o valor das parcelas para as 3 formas de pagamento, com o valor de aquisição de 10.000
Observação as parcelas serão gravadas individualmente em uma tabela utilizando cursores.
*/
create sequence sequence_compra start with 0 minvalue 0\\

CREATE TABLE COMPRA(
    ID NUMBER CONSTRAINT COMPRA_ID_NN NOT NULL,
    VALOR NUMBER CONSTRAINT COMPRA_VALOR_NN NOT NULL,
    PRIMARY KEY(ID)
)

CREATE TABLE PARCELA6 (
    VALOR NUMBER,
    COMPRA_ID NUMBER CONSTRAINT PARCELA6_COMPRA_ID_NN NOT NULL,
    FOREIGN KEY(COMPRA_ID) REFERENCES COMPRA(ID)
)

CREATE TABLE PARCELA12 (
    VALOR NUMBER,
    COMPRA_ID NUMBER CONSTRAINT PARCELA12_COMPRA_ID_NN NOT NULL,
    FOREIGN KEY(COMPRA_ID) REFERENCES COMPRA(ID)
)

CREATE TABLE PARCELA18 (
    VALOR NUMBER,
    COMPRA_ID NUMBER CONSTRAINT PARCELA_COMPRA18_ID_NN NOT NULL,
    FOREIGN KEY(COMPRA_ID) REFERENCES COMPRA(ID)
)

DECLARE
    contador NUMBER :=0;
    ID_COMPRA number := sequence_compra.nextval;
    VALOR_COMPRA NUMBER:= 20000;
    VALOR_ENTRADA NUMBER;
    VALOR_PARCELA_6 NUMBER;
    VALOR_PARCELA_12 NUMBER;
    VALOR_PARCELA_18 NUMBER;
    CURSOR C6(V_CODCOMPRA in COMPRA.ID%TYPE) IS SELECT VALOR FROM PARCELA6 WHERE COMPRA_ID = V_CODCOMPRA  FOR UPDATE OF VALOR;
    CURSOR C12(V_CODCOMPRA in COMPRA.ID%TYPE) IS SELECT VALOR FROM PARCELA12 WHERE COMPRA_ID = V_CODCOMPRA FOR UPDATE OF VALOR;
    CURSOR C18(V_CODCOMPRA in COMPRA.ID%TYPE) IS SELECT VALOR FROM PARCELA18 WHERE COMPRA_ID = V_CODCOMPRA FOR UPDATE OF VALOR;
BEGIN
	insert into COMPRA(ID,VALOR) values (ID_COMPRA,VALOR_COMPRA);
	
    while contador < 6 loop
        insert into PARCELA6(VALOR,COMPRA_ID) VALUES (0,ID_COMPRA);
		contador:= contador + 1;
	end loop;
	
	contador:= 0;
	while contador < 12 loop
        insert into PARCELA12(VALOR,COMPRA_ID) VALUES(0,ID_COMPRA);
		contador:= contador + 1;
    end loop;
    
	contador:= 0;
	while contador < 18 loop
        insert into PARCELA18(VALOR,COMPRA_ID) VALUES(0,ID_COMPRA);
		contador:= contador + 1;
    end loop;
	
    VALOR_ENTRADA:= VALOR_COMPRA * 0.2;
    VALOR_COMPRA:= VALOR_COMPRA - VALOR_ENTRADA;
    VALOR_PARCELA_6:=VALOR_COMPRA + (VALOR_COMPRA * 0.1);
    VALOR_PARCELA_12:=VALOR_COMPRA + (VALOR_COMPRA * 0.15);
    VALOR_PARCELA_18:=VALOR_COMPRA + (VALOR_COMPRA * 0.20);
	
	for RC1 in C6(ID_COMPRA) loop
		UPDATE PARCELA6 SET VALOR = VALOR_PARCELA_6 WHERE current of C6;
	end loop;
	
	for RC1 in C12(ID_COMPRA) loop
		UPDATE PARCELA12 SET VALOR = VALOR_PARCELA_12 WHERE current of C12;
	end loop;
	
	for RC1 in C18(ID_COMPRA) loop
		UPDATE PARCELA18 SET VALOR = VALOR_PARCELA_18 WHERE current of C18;
	end loop;
END;