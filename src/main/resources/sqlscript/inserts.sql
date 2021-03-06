 /*
 OBJTYPE - таблица описаний объектных типов
 ATTRTYPE - таблица описаний атрибутных типов
 LISTS - список для листовых значений
 OBJECTS - таблица обьектов 
 ATTRIBUTES - таблица атрибутов 
 OBJREFERENCE - описаний связей "простая ассоциация" между экземплярами объектов
 */
 
 --ЗАПОЛНЕНИЕ ОБЬЕКТНЫХ ТИПОВ
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (100,NULL,'REPORT','report');
-- обьектный абстрактный тип - отчет
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (200,NULL,'CATEGORY_INCOME','category for report income');
-- обьектный абстрактный тип - категория дохода
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (300,NULL,'CATEGORY_EXPENSE','category for report expense');
-- обьектный абстрактный тип - категория расохда
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (400,NULL,'TRANSACTION_INCOME','transaction income');
-- обьектный абстрактный тип - транзакция дохода
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (500,NULL,'TRANSACTION_EXPENSE','transaction expense');
-- обьектный абстрактный тип - транзакция расохда
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (600,NULL,'CREDIT_ACCOUNT','credit account');
-- обьектный абстрактный тип - кредитный аккаунт
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (700,NULL,'CREDIT_ACCOUNT_OPERATION','credit account operation');
-- обьектный абстрактный тип - кредитный аккаунт операция
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (800,NULL,'DEBT','debt');
-- обьектный абстрактный тип - кредитный аккаунт операция






 
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (1,NULL,'USER',NULL);
-- обьектный тип - пользователь
 INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (2,null,'PER_DEB_ACC','Personal debet account');
-- обьектный тип - персональный дебеторный аккаунт
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (3,100,'PER_REP','Personal report');
-- обьектный тип - персональный отчет 
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (4,200,'CAT_REP_PER_INC','Catery report personal income');
-- обьектный тип - персональный отчет по категории доходов
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (5,300,'CAT_REP_PER_EXP','Catery report personal expense');
-- обьектный тип - персональный отчет по категории расходов
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (6,600,'CRED_ACC_PER','credit account Personal');
-- обьектный тип - персональный кредитный аккаунт
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (7,700,'CRED_OPER_PER','credit operation Personal');
-- обьектный тип - персональный кредитная операция
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (8,800,' DEBT_PER','debt Personal');
-- обьектный тип - персональный долг
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (9,500,'ACC_EXPEN_PER','account expense personal');
-- обьектный тип - персональные расходы
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (10,400,'ACC_INC_PER','account income personal');
-- обьектный тип - персональные доходы
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (11,500,'ACC_AUTO_EXPEN_PER','account autoexpense personal');
-- обьектный тип - персональные авторасходы
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (12,400,'ACC_AUTO_INC_PER','account autoincome personal');
-- обьектный тип - персональные автодоходы


 INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (13,null,'FAM_DEB_ACC','Family debet account');
-- обьектный тип - семейный дебеторный аккаунт
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (14,100,'FAM_REP','Family report');
-- обьектный тип - семейный отчет
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (15,200,'CAT_REP_FAM_INC','Catery report family income');
-- обьектный тип - семейный отчет по категории доходов
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (16,300,'CAT_REP_FAM_EXP','Catery report family expense');
-- обьектный тип - семейный отчет по категории расходов
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (17,600,'CRED_ACC_FAM','credit account Family');
-- обьектный тип - семейный кредитный аккаунт
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (18,700,'CRED_OPER_FAM','credit operation Family');
-- обьектный тип - семейный кредитная операция
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (19,800,' DEBT_FAM','debt family');
-- обьектный тип - семеный долг
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (20,500,'ACC_EXPEN_FAM','account expense Family');
-- обьектный тип - семейные расходы
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (21,400,'ACC_INC_FAM','account income Family');
-- обьектный тип - семейные доходы
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (22,500,'ACC_AUTO_EXPEN_FAM','account autoexpense personal family');
-- обьектный тип - семейные авторасходы
INSERT INTO OBJTYPE (OBJECT_TYPE_ID,PARENT_ID,NAME,DESCRIPTION) VALUES (23,400,'ACC_AUTO_INC_FAM','account autoincome personal family');
-- обьектный тип - семейные автодоходы

--ЗАПОЛНЕНИЕ ТИПОВ АТРИБУТОВ
--USER
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (1,1,2,'OWNER_PERSONAL_ACC');
 -- REFERENCE TO PERSONAL ACCOUNT
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (2,1,13,'OWNER_FAMILY_ACC');
 -- REFERENCE TO FAMILY ACCOUNT
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (3,1,NULL,'MAIL');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (4,1,NULL,'PASSWORD');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (5,1,NULL,'NAME');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (6,1,NULL,'IS_ACTIVE');


--PERSONAL ACCOUNT
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (7,2,NULL,'AMOUNT');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (70,2,NULL,'ISACTIVE');
--FAMILY ACCOUNT
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (8,13,1,'PARTICIPANT_FAMILY_ACC');
--REFERENCE TO USER

INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (9,13,NULL,'AMOUNT');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (69,13,NULL,'ISACTIVE');

--PERSONAL REPORT REFERENCE
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (10,3,2,'PERSONAL_DEBET_ACCOUNT_ID');
-- FAMILY REPORT REFERENCE
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (11,14,13,'FAMILY_DEBET_ACCOUNT_ID');
-- TYPE ATTR REPORT
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (12,100,NULL,'TOTAL_INCOME');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (13,100,NULL,'TOTAL_EXPENSE');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (14,100,NULL,'BALANCE');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (15,100,NULL,'DATE_FROM');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (16,100,NULL,'DATE_TO');

--CATEGORY REPORT INCOME
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (17,4,3,'CATEGORY_PERSONAL_REPORT');
-- REFERENCE TO PERSONAL REPORT

--FAMILY
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (18,15,14,'CATEGORY_FAMILY_REPORT');
-- REFERENCE TO FAMILY REPORT
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (19,15,1,'CATEGORY_FAMILY_REPORT_USER_ID');
-- REFERENCE TO USER AS A PARTICIPANT FAMILY BILL

--TYPE ATTR CATEGORY REPORT
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (20,200,NULL,'category name');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (21,200,NULL,'amount');

--CATEGORY REPORT EXPENSE
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (22,5,3,'CATEGORY_PERSONAL_REPORT');
-- REFERENCE TO PERSONAL REPORT

--FAMILY
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (23,16,14,'CATEGORY_FAMILY_REPORT');
-- REFERENCE TO FAMILY REPORT
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (24,16,1,'CATEGORY_FAMILY_REPORT_USER_ID');
-- REFERENCE TO USER AS A PARTICIPANT FAMILY BILL

--TYPE ATTR CATEGORY REPORT
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (25,300,NULL,'category name');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (26,300,NULL,'amount');


-- CREDIT ACCOUNT REFERENCE
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (27,6,2,'PERSONAL_DEBET_ACCOUNT_ID');
--PERSONAL

INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (28,17,13,'FAMILY_DEBET_ACCOUNT_ID');
--FAMILY

-- CREDIT ACCOUNT TYPE ATTR
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (29,600,NULL,'DATE');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (30,600,NULL,'NAME');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (31,600,NULL,'AMOUNT');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (32,600,NULL,'PAID_AMOUNT');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (33,600,NULL,'CREDIT_RATE');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (34,600,NULL,'DATE_TO');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (35,600,NULL,'IS_PAID');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (36,600,NULL,'MONTH_DAY');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (72,600,NULL,'IS_COMMODITY');


--CREDIT OPERATION  REFERENCE
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (37,7,6,'CREDIT_ACCOUNT_ID_PERSONAL');
--PERSONAL

INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (38,18,17,'CREDIT_ACCOUNT_ID_FAMILY');
--FAMILY

INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (39,18,1,'CREDIT_ACCOUNT_ID_USER');
--FAMILY PARTICIPANT USER

--TYPE ATTR CREDIT OPERATION
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (40,700,NULL,'AMOUNT');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (41,700,NULL,'DATE');


--DEBT 
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (42,8,6,'PERSONAL_CREDIT_ACCOUNT_ID');
--PERSONAL

INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (43,19,17,'FAMILY_CREDIT_ACCOUNT_ID');
--FAMILY

--TYPE ATTR DEBT 
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (44,800,NULL,'DATE_FROM');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (45,800,NULL,'DATE_TO');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (46,800,NULL,'AMOUNT_DEBT');



--TRANSACTION expense
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (47,9,2,'PERSONAL_DEBET_ACCOUNT_ID');
--PERSONAL

INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (48,20,13,'FAMILY_DEBET_ACCOUNT_ID');
--FAMILY

INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (49,20,1,'TRANSACTION_EXPENSE_USER_ID');
--FAMILY participant user EXPENSE

--TYPE ATTR TRANSACTION expense 
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (50,500,NULL,'AMOUNT');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (51,500,NULL,'CATEGORY');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (52,500,NULL,'DATE');

--TRANSACTION INCOME
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (53,10,2,'PERSONAL_DEBET_ACCOUNT_ID');
--PERSONAL

INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (54,21,13,'FAMILY_DEBET_ACCOUNT_ID');
--FAMILY
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (55,21,1,'TRANSACTION_INCOME_USER_ID');
--FAMILY participant user income

--TYPE ATTR TRANSACTION INCOME 
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (56,400,NULL,'AMOUNT');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (57,400,NULL,'CATEGORY');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (58,400,NULL,'DATE');

--AUTOOPERATION EXPENSE
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (59,11,2,'PERSONAL_DEBET_ACCOUNT_ID');
--PERSONAL

INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (60,22,13,'FAMILY_DEBET_ACCOUNT_ID');
--FAMILY
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (61,22,1,'TRANSACTION_AUTOEXPENSE_USER_ID');
--FAMILY participant user income

--TYPE ATTR AUTOOPERATION EXPENSE
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (62,11,NULL,'DAY_OF_MONTH');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (63,22,NULL,'DAY_OF_MONTH');

--AUTOOPERATION INCOME
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (64,12,2,'PERSONAL_DEBET_ACCOUNT_ID');
--PERSONAL

INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (65,23,13,'FAMILY_DEBET_ACCOUNT_ID');
--FAMILY
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (66,23,1,'TRANSACTION_AUTOEXPENSE_USER_ID');
--FAMILY participant user income

--TYPE ATTR AUTOOPERATION INCOME
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (67,12,NULL,'DAY_OF_MONTH');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (68,23,NULL,'DAY_OF_MONTH');

--ROLE
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (71,1,NULL,'ROLE');
INSERT INTO ATTRTYPE (ATTR_ID,OBJECT_TYPE_ID,OBJECT_TYPE_ID_REF,NAME) VALUES (73,1,NULL,'PASS_TOKEN');


--LISTS
-- атрибут категории для операции расхода
insert into Lists(attr_id, list_value_id, value) values(51, 1, 'FOOD');
insert into Lists(attr_id, list_value_id, value) values(51, 2, 'RESIDENTIAL');
insert into Lists(attr_id, list_value_id, value) values(51, 3, 'ENTERTAINMENT');
insert into Lists(attr_id, list_value_id, value) values(51, 4, 'TAXES');
insert into Lists(attr_id, list_value_id, value) values(51, 5, 'EDUCATION');
insert into Lists(attr_id, list_value_id, value) values(51, 6, 'MEDICINE');
insert into Lists(attr_id, list_value_id, value) values(51, 7, 'TRANSPORT');
insert into Lists(attr_id, list_value_id, value) values(51, 8, 'GIFTS');
insert into Lists(attr_id, list_value_id, value) values(51, 9, 'CHILDREN');
insert into Lists(attr_id, list_value_id, value) values(51, 10, 'SPORT');
insert into Lists(attr_id, list_value_id, value) values(51, 11, 'CLOTHES');
insert into Lists(attr_id, list_value_id, value) values(51, 12, 'CREDIT');
insert into Lists(attr_id, list_value_id, value) values(51, 13, 'OTHER');

-- атрибут категории для операции дохода
insert into Lists(attr_id, list_value_id, value) values(57, 14, 'SALARY');
insert into Lists(attr_id, list_value_id, value) values(57, 15, 'AWARD');
insert into Lists(attr_id, list_value_id, value) values(57, 16, 'PRESENTS');
insert into Lists(attr_id, list_value_id, value) values(57, 17, 'GIFTS');
insert into Lists(attr_id, list_value_id, value) values(57, 18, 'OTHER');
insert into Lists(attr_id, list_value_id, value) values(57, 49, 'CREDIT');

-- REPORT CATEGORY AS EXPENSE
insert into Lists(attr_id, list_value_id, value) values(25, 19, 'FOOD');
insert into Lists(attr_id, list_value_id, value) values(25, 20, 'RESIDENTIAL');
insert into Lists(attr_id, list_value_id, value) values(25, 21, 'ENTERTAINMENT');
insert into Lists(attr_id, list_value_id, value) values(25, 22, 'TAXES');
insert into Lists(attr_id, list_value_id, value) values(25, 23, 'EDUCATION');
insert into Lists(attr_id, list_value_id, value) values(25, 24, 'MEDICINE');
insert into Lists(attr_id, list_value_id, value) values(25, 25, 'TRANSPORT');
insert into Lists(attr_id, list_value_id, value) values(25, 26, 'GIFTS');
insert into Lists(attr_id, list_value_id, value) values(25, 27, 'CHILDREN');
insert into Lists(attr_id, list_value_id, value) values(25, 28, 'SPORT');
insert into Lists(attr_id, list_value_id, value) values(25, 29, 'CLOTHES');
insert into Lists(attr_id, list_value_id, value) values(25, 30, 'CREDIT');
insert into Lists(attr_id, list_value_id, value) values(25, 31, 'OTHER');


-- REPORT CATEGORY AS INCOME
insert into Lists(attr_id, list_value_id, value) values(20, 32, 'SALARY');
insert into Lists(attr_id, list_value_id, value) values(20, 33, 'AWARD');
insert into Lists(attr_id, list_value_id, value) values(20, 34, 'PRESENTS');
insert into Lists(attr_id, list_value_id, value) values(20, 35, 'GIFTS');
insert into Lists(attr_id, list_value_id, value) values(20, 36, 'OTHER');
insert into Lists(attr_id, list_value_id, value) values(20, 48, 'CREDIT');

-- CREDIT IS PAID
insert into Lists(attr_id, list_value_id, value) values(35, 37, 'YES');
insert into Lists(attr_id, list_value_id, value) values(35, 38, 'NO');

-- USER IS ACTIVE
insert into Lists(attr_id, list_value_id, value) values(6, 39, 'YES');
insert into Lists(attr_id, list_value_id, value) values(6, 40, 'NO');

-- FAMILY ACC IS ACTIVE
insert into Lists(attr_id, list_value_id, value) values(69, 41, 'YES');
insert into Lists(attr_id, list_value_id, value) values(69, 42, 'NO');

-- PERSONAL ACC IS ACTIVE
insert into Lists(attr_id, list_value_id, value) values(70, 43, 'YES');
insert into Lists(attr_id, list_value_id, value) values(70, 44, 'NO');

-- ROLE
insert into Lists(attr_id, list_value_id, value) values(71, 45, 'USER');
insert into Lists(attr_id, list_value_id, value) values(71, 46, 'OWNER');
insert into Lists(attr_id, list_value_id, value) values(71, 47, 'PARTICIPANT');

COMMIT;
