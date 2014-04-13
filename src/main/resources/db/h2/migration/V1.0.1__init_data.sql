--table org_user

    Insert into ORG_USER (ID,CODE,SEX,CREATED_BY,CREATED_DATE,VERSION,NAME,TYPE,EMAIL,TEL,STATUS) 
    values ('admin','admin',0,'system',CURRENT_DATE(),1,'administrator','staff','admin@sunisco.com','12345678901',1);

--table org_user_defaults

    Insert into ORG_USER_DEFAULTS (ID,NAME,CREATED_BY,CREATED_DATE,VALUE,ORG_USER_CODE,VERSION) 
    values ('adminprofile','inspireso.profile-page-name','system',null,'sec/functiongroupmanager','admin',1);

--table org_group

    Insert into ORG_GROUP (ID,NAME,CODE,PARENT,CREATED_BY,CREATED_DATE,VERSION,LEADER_ID,ORDER_BY,SYSTEM) 
    values ('__partner__','partner','__partner__',null,'system',CURRENT_DATE(),1,null,0,1);

    Insert into ORG_GROUP (ID,NAME,CODE,PARENT,CREATED_BY,CREATED_DATE,VERSION,LEADER_ID,ORDER_BY,SYSTEM) 
    values ('__admin__','admin','__admin__',null,'system',CURRENT_DATE(),1,null,0,0);

--table org_user_group_ref

    Insert into ORG_USER_GROUP_REF (ORG_USER_ID,ORG_GROUP_ID) 
    values ('admin','__admin__');

-- table aut_account

    Insert into AUT_ACCOUNT (ID,VERSION,PASSWORD,CREATED_BY,CREATED_DATE,ORG_USER_CODE,TEMPORARY_PASSWORD) 
    values ('admin',1,'0dfbcc82d7df6416976c93fc29bee5ab','system',CURRENT_DATE(),'admin',null);

-- table aut_function

    Insert into AUT_FUNCTION (ID,NAME,CREATED_BY,CREATED_DATE,VERSION,URL,ORDER_BY,DESCRIPTION,TYPE,GROUP_NAME)
    values ('fun001','管理员.功能','system',CURRENT_DATE(),1,'sec/functionmanager',10,'开发人员使用,用户管理当前系统可用的功能页面',3,'resource');
    
    Insert into AUT_FUNCTION (ID,NAME,CREATED_BY,CREATED_DATE,VERSION,URL,ORDER_BY,DESCRIPTION,TYPE,GROUP_NAME)
    values ('fun002','管理员.授权','system',CURRENT_DATE(),1,'sec/functiongroupmanager',12,'内部用户使用，用于管理各种用户组可操作的功能',3,'resource');

    Insert into AUT_FUNCTION (ID,NAME,CREATED_BY,CREATED_DATE,VERSION,URL,ORDER_BY,DESCRIPTION,TYPE,GROUP_NAME) 
    values ('fun003','管理员.员工','system',CURRENT_DATE(),1,'sec/staffmanager',13,'管理当前系统的内部账户',3,'resource');

     Insert into AUT_FUNCTION (ID,NAME,CREATED_BY,CREATED_DATE,VERSION,URL,ORDER_BY,DESCRIPTION,TYPE,GROUP_NAME) 
    values ('fun004','员工信息.简介','system',CURRENT_DATE(),1,'my/about',20,'查看编辑员工自己的基本信息',3,'staff.profile');
               
    Insert into AUT_FUNCTION (ID,NAME,CREATED_BY,CREATED_DATE,VERSION,URL,ORDER_BY,DESCRIPTION,TYPE,GROUP_NAME) 
    values ('fun005','员工信息.修改密码','system',CURRENT_DATE(),1,'my/passwd',21,'修该自己的密码',3,'staff.profile');
    
    Insert into AUT_FUNCTION (ID,NAME,CREATED_BY,CREATED_DATE,VERSION,URL,ORDER_BY,DESCRIPTION,TYPE,GROUP_NAME) 
    values ('fun006','重置密码','system',CURRENT_DATE(),1,'sec/passreset',22,'重置密码页面',0,null);
    
    Insert into AUT_FUNCTION (ID,NAME,CREATED_BY,CREATED_DATE,VERSION,URL,ORDER_BY,DESCRIPTION,TYPE,GROUP_NAME) 
    values ('fun010','基础数据.产品','system',CURRENT_DATE(),1,'example/products',31,null,3,'setting');

    Insert into AUT_FUNCTION (ID,NAME,CREATED_BY,CREATED_DATE,VERSION,URL,ORDER_BY,DESCRIPTION,TYPE,GROUP_NAME) 
    values ('fun011','基础数据.价格表','system',CURRENT_DATE(),1,'example/pricelists',32,null,3,'setting');
    

--table aut_function_group_ref

    Insert into AUT_FUNCTION_GROUP_REF (AUT_FUNCTION_ID,ORG_GROUP_ID) 
    values ('fun002','__admin__');