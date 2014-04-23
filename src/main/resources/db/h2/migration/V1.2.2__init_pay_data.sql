-- table aut_function

    Insert into AUT_FUNCTION (ID,NAME,CREATED_BY,CREATED_DATE,VERSION,URL,ORDER_BY,DESCRIPTION,TYPE,GROUP_NAME) 
    values ('fun021','账户中心.我的账户','system',CURRENT_DATE(),1,'pay/account/index',30,null,3,'wallet');
    
    Insert into AUT_FUNCTION (ID,NAME,CREATED_BY,CREATED_DATE,VERSION,URL,ORDER_BY,DESCRIPTION,TYPE,GROUP_NAME) 
    values ('fun022','账户中心.支付密码','system',CURRENT_DATE(),1,'pay/account/passwd',31,null,3,'wallet');
    
    Insert into AUT_FUNCTION (ID,NAME,CREATED_BY,CREATED_DATE,VERSION,URL,ORDER_BY,DESCRIPTION,TYPE,GROUP_NAME) 
    values ('fun023','账户中心.充值','system',CURRENT_DATE(),1,'pay/account/recharge',0,null,0,null);
    
    Insert into AUT_FUNCTION (ID,NAME,CREATED_BY,CREATED_DATE,VERSION,URL,ORDER_BY,DESCRIPTION,TYPE,GROUP_NAME) 
    values ('fun024','账户中心.收银台','system',CURRENT_DATE(),1,'pay/cashier',0,null,0,null);
    
    Insert into AUT_FUNCTION (ID,NAME,CREATED_BY,CREATED_DATE,VERSION,URL,ORDER_BY,DESCRIPTION,TYPE,GROUP_NAME) 
    values ('fun025','账户中心.网银支付','system',CURRENT_DATE(),1,'pay/payment',0,null,0,null);