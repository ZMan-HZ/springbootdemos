
-- CREATE SEQUENCE CUSTOMERS_AUTO_ID
--     INCREMENT BY 1
--     START WITH 1
--     MINVALUE 1
--     MAXVALUE 999999999
--     NOCYCLE
--     NOCACHE
-- ;
-- CREATE OR REPLACE TRIGGER CUSTOMERS_AUTOID_TRIGGER
--     BEFORE
--         INSERT
--     ON CUSTOMERS_LIST
--     FOR EACH ROW
-- DECLARE
--     nextID number;
-- begin
--     if :new.ID is null then
--         SELECT to_char(current_date, 'yyyymmddhh24miss') || CUSTOMERS_AUTO_ID.NEXTVAL
--         into nextID
--         FROM DUAL;
--         :new.ID := nextID;
--     end if;
-- end CUSTOMERS_AUTOID_TRIGGER;

--DELETE  FROM CUSTOMERS_LIST;

INSERT INTO CUSTOMERS_LIST(NAME,
                             GENDER,
                             BIRTHDAY,
                             EMAIL,
                             CONTACT_NUMBER,
                             CITY,
                             DISTRICT,
                             ZIP_CODE,
                             START_DATE,
                             END_DATE,
                             LAST_UPDATED_BY)
VALUES ('Lisa', 'M', TO_DATE('1992-09-17', 'yyyy-MM-dd'), 'lisa@163.com', '18868522685', 'Hangzhou', 'Xihu', 310010,
        CURRENT_DATE, ADD_MONTHS(CURRENT_DATE, 36), 'MZZ');

INSERT INTO CUSTOMERS_LIST(NAME,
                             GENDER,
                             BIRTHDAY,
                             EMAIL,
                             CONTACT_NUMBER,
                             CITY,
                             DISTRICT,
                             ZIP_CODE,
                             START_DATE,
                             END_DATE,
                             LAST_UPDATED_BY)
VALUES ('Alex', 'F', TO_DATE('1994-01-13', 'yyyy-MM-dd'), 'Alex@qq.com', '15254587118', 'Hangzhou', 'GongShu', 310012,
        CURRENT_DATE, ADD_MONTHS(CURRENT_DATE, 36), 'MZZ');

INSERT INTO CUSTOMERS_LIST(NAME,
                             GENDER,
                             BIRTHDAY,
                             EMAIL,
                             CONTACT_NUMBER,
                             CITY,
                             DISTRICT,
                             ZIP_CODE,
                             START_DATE,
                             END_DATE,
                             LAST_UPDATED_BY)
VALUES ('Bob', 'F', TO_DATE('1996-03-15', 'yyyy-MM-dd'), 'lisa@qq.com', '18978767652', 'Hangzhou', 'XiaCheng', 310008,
        CURRENT_DATE, ADD_MONTHS(CURRENT_DATE, 36), 'MZZ');

INSERT INTO CUSTOMERS_LIST(NAME,
                             GENDER,
                             BIRTHDAY,
                             EMAIL,
                             CONTACT_NUMBER,
                             CITY,
                             DISTRICT,
                             ZIP_CODE,
                             START_DATE,
                             END_DATE,
                             LAST_UPDATED_BY)
VALUES ('Carly', 'M', TO_DATE('1998-05-19', 'yyyy-MM-dd'), 'Carly@qq.com', '18534522567', 'Hangzhou', 'ShangCheng',
        310009, CURRENT_DATE, ADD_MONTHS(CURRENT_DATE, 36), 'MZZ');

INSERT INTO CUSTOMERS_LIST(NAME,
                             GENDER,
                             BIRTHDAY,
                             EMAIL,
                             CONTACT_NUMBER,
                             CITY,
                             DISTRICT,
                             ZIP_CODE,
                             START_DATE,
                             END_DATE,
                             LAST_UPDATED_BY)
VALUES ('Daphna', 'M', TO_DATE('1990-07-27', 'yyyy-MM-dd'), 'Daphna@qq.com', '18646722358', 'Hangzhou', 'BinJiang',
        310013, CURRENT_DATE, ADD_MONTHS(CURRENT_DATE, 36), 'MZZ');

INSERT INTO CUSTOMERS_LIST(NAME,
                             GENDER,
                             BIRTHDAY,
                             EMAIL,
                             CONTACT_NUMBER,
                             CITY,
                             DISTRICT,
                             ZIP_CODE,
                             START_DATE,
                             END_DATE,
                             LAST_UPDATED_BY)
VALUES ('Eric', 'F', TO_DATE('1991-09-07', 'yyyy-MM-dd'), 'Eric@qq.com', '1875462764', 'Hangzhou', 'XiaoShan', 310020,
        CURRENT_DATE, ADD_MONTHS(CURRENT_DATE, 36), 'MZZ');

INSERT INTO CUSTOMERS_LIST(NAME,
                             GENDER,
                             BIRTHDAY,
                             EMAIL,
                             CONTACT_NUMBER,
                             CITY,
                             DISTRICT,
                             ZIP_CODE,
                             START_DATE,
                             END_DATE,
                             LAST_UPDATED_BY)
VALUES ('Frank', 'M', TO_DATE('1989-12-11', 'yyyy-MM-dd'), 'Frank@qq.com', '18644522846', 'Hangzhou', 'YuHnag',
        310023, CURRENT_DATE, ADD_MONTHS(CURRENT_DATE, 36), 'MZZ');

INSERT INTO CUSTOMERS_LIST(NAME,
                             GENDER,
                             BIRTHDAY,
                             EMAIL,
                             CONTACT_NUMBER,
                             CITY,
                             DISTRICT,
                             ZIP_CODE,
                             START_DATE,
                             END_DATE,
                             LAST_UPDATED_BY)
VALUES ('Graced', 'M', TO_DATE('1993-10-09', 'yyyy-MM-dd'), 'Graced@qq.com', '187565422537', 'Hangzhou', 'Xihu',
        310010, CURRENT_DATE, ADD_MONTHS(CURRENT_DATE, 36), 'MZZ');

INSERT INTO CUSTOMERS_LIST(NAME,
                             GENDER,
                             BIRTHDAY,
                             EMAIL,
                             CONTACT_NUMBER,
                             CITY,
                             DISTRICT,
                             ZIP_CODE,
                             START_DATE,
                             END_DATE,
                             LAST_UPDATED_BY)
VALUES ('Hank', 'F', TO_DATE('1995-08-16', 'yyyy-MM-dd'), 'Hank@qq.com', '18434562375', 'Hangzhou', 'FuYang', 310032,
        CURRENT_DATE, ADD_MONTHS(CURRENT_DATE, 36), 'MZZ');

INSERT INTO CUSTOMERS_LIST(NAME,
                             GENDER,
                             BIRTHDAY,
                             EMAIL,
                             CONTACT_NUMBER,
                             CITY,
                             DISTRICT,
                             ZIP_CODE,
                             START_DATE,
                             END_DATE,
                             LAST_UPDATED_BY)
VALUES ('Iris', 'M', TO_DATE('1997-06-18', 'yyyy-MM-dd'), 'Iris@qq.com', '18868522574', 'Hangzhou', 'LinAn', 310038,
        CURRENT_DATE, ADD_MONTHS(CURRENT_DATE, 36), 'MZZ');

DELETE FROM DEPARTMENT_LIST;

INSERT INTO DEPARTMENT_LIST(ZIP_CODE,
                              DISTRICT,
                              ADDRESS,
                              CITY)
VALUES (310010, 'Xihu', NULL, 'Hangzhou');