



select nm_func, nm_sobrenome, dt_nasc from func where nm_func = 'joao' or nm_func = 'maria';

CREATE TABLE TOYS(
ID NUMBER,
DESCR VARCHAR2(20));
INSERT INTO TOYS VALUES (1,'TOY1');
INSERT INTO TOYS VALUES (2,'T1OY2');
INSERT INTO TOYS VALUES (3,'1TOY1');
INSERT INTO TOYS VALUES (4,'999');
INSERT INTO TOYS VALUES (5,'8888');
INSERT INTO TOYS VALUES (6,'TOY2007');
COMMIT;

SELECT DESCR FROM TOYS
WHERE REGEXP_LIKE(DESCR,'[^[:digit:]]');

SELECT REGEXP_COUNT('Rodrigo Righetti','i',2,'c') CONTADOR from dual;
/*
realiza busca do caractere 'i'
iniciando a busca a partir da
segunda posição e apenas caracteres
minúsculos devido ao 'c'
*/
SELECT REGEXP_COUNT('Ricardo Rezende','R',1,'c') CONTADOR from dual;

SELECT REGEXP_REPLACE('RodrigoRighetti','(){0,}',' ') from dual;
SELECT REGEXP_REPLACE('Rodrigo Righetti','(){1,}','%') from dual;
SELECT REGEXP_REPLACE('Rodrigo Righetti','()|( )|(%){1,}','') from dual;

SELECT REGEXP_REPLACE(DESCR,'[^[:alpha:]]')FROM TOYS;

SELECT REGEXP_INSTR('ASTRINGWITHNUMBERS1234 ETC','[^[:alpha]]') FROM DUAL;
