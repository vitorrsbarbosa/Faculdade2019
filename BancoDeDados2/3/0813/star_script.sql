
CREATE SEQUENCE ORGAO_SUBORDINADO_SK_ORGAO_352;

CREATE TABLE Orgao_Subordinado (
                SK_Orgao_Subordinado NUMBER NOT NULL,
                CONSTRAINT ORGAO_SUBORDINADO_PK PRIMARY KEY (SK_Orgao_Subordinado)
);


CREATE SEQUENCE TEMPO_SK_TEMPO_SEQ;

CREATE TABLE Tempo (
                SK_Tempo NUMBER NOT NULL,
                Dia VARCHAR2 NOT NULL,
                Mes VARCHAR2 NOT NULL,
                Ano VARCHAR2 NOT NULL,
                Hora VARCHAR2 NOT NULL,
                CONSTRAINT TEMPO_PK PRIMARY KEY (SK_Tempo)
);


CREATE SEQUENCE ORGAO_SUPERIOR_SK_ORGAO_SUP556;

CREATE TABLE Orgao_Superior (
                SK_Orgao_Superior NUMBER NOT NULL,
                Nome_Orgao_Superior VARCHAR2 NOT NULL,
                CONSTRAINT _ORGAO_SUPERIOR_PK PRIMARY KEY (SK_Orgao_Superior)
);


CREATE SEQUENCE FATO_SK_FATO_SEQ;

CREATE TABLE Fato (
                SK_Fato NUMBER NOT NULL,
                SK_Orgao_Superior NUMBER NOT NULL,
                SK_Orgao_Subordinado NUMBER NOT NULL,
                SK_Tempo NUMBER NOT NULL,
                CONSTRAINT FATO_PK PRIMARY KEY (SK_Fato, SK_Orgao_Superior, SK_Orgao_Subordinado, SK_Tempo)
);


ALTER TABLE Fato ADD CONSTRAINT ORGAO_SUBORDINADO_FATO_FK
FOREIGN KEY (SK_Orgao_Subordinado)
REFERENCES Orgao_Subordinado (SK_Orgao_Subordinado)
NOT DEFERRABLE;

ALTER TABLE Fato ADD CONSTRAINT TEMPO_FATO_FK
FOREIGN KEY (SK_Tempo)
REFERENCES Tempo (SK_Tempo)
NOT DEFERRABLE;

ALTER TABLE Fato ADD CONSTRAINT ORGAO_SUPERIOR_FATO_FK
FOREIGN KEY (SK_Orgao_Superior)
REFERENCES Orgao_Superior (SK_Orgao_Superior)
NOT DEFERRABLE;
