insert into user (user_seq, email, password, status) values (1, 'javajigi@slipp.net', 'test', 1);
insert into user (user_seq, email, password, status) values (2, 'sanjigi@slipp.net', 'test', 1);

insert into user_role (user_id, role) values (1, 'ROLE_USER');
insert into user_role (user_id, role) values (2, 'ROLE_USER');
insert into user_role (user_id, role) values (2, 'ROLE_ADMIN');

INSERT INTO project(project_seq, user_user_seq, project_id, admin_email, status, reg_date, ok_key) VALUES (1,1,'astute-charter-133923','rhcho@rockplace.co.kr',1,'2016-12-26 15:51:22',NULL),(2,1,'rp-internal-1243','rhcho@rockplace.co.kr',0,'2016-12-26 15:51:22',NULL);


INSERT INTO dash_board(invoice_seq,account_id,cost,line_item,start_time,end_time,project,measurement1,measurement1total_consumption,measurement1units,credit1,credit1amount,credit1currency,cost,currency,project_number,project_id,project_name,project_labels,description,invoice_file_name,update_date) VALUES (1,'00C7AF-773114-6DB700',100,'com.google.cloud/services/app-engine/TotalAppSizeBytes','2016-07-26','2016-07-27','139603012520','com.google.cloud/services/app-engine/TotalAppSizeBytes','0','byte-seconds',NULL,NULL,NULL,'0','USD','139603012520','astute-charter-133923','My Project','','Code and Static File Storage',NULL,'2016-12-22 11:20:03'),(2,'00C7AF-773114-6DB700',200,'com.googleapis/services/pubsub/MessageOperations','2016-07-26','2016-07-27','139603012520','com.googleapis/services/pubsub/Message_operation','2','requests',NULL,NULL,NULL,'0','USD','139603012520','astute-charter-133923','My Project','','Message Operations',NULL,'2016-12-22 11:20:03'),(3,'00C7AF-773114-6DB700',300,'com.googleapis/services/pubsub/MessageOperations','2016-07-27','2016-07-28','139603012520','com.googleapis/services/pubsub/Message_operation','96','requests',NULL,NULL,NULL,'0','USD','139603012520','astute-charter-133923','My Project','','Message Operations',NULL,'2016-12-22 11:20:03');