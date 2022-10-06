DROP TABLE IF EXISTS `T_MEMBER`;

--  멤버
CREATE TABLE T_MEMBER (
  memberNum int auto_increment,
  email varchar(40) NOT NULL,
  pw varchar(20) NOT NULL,
  nickName varchar(50) NOT NULL,
  memberTel varchar(20) NOT NULL,
--  memberPoint int NOT NULL, -- 포인트 일단 빼고
  memberGrade int NOT NULL, --  회원 등급: 일반회원, 판매자, 관리자
  PRIMARY KEY (`memberNum `)
)AUTO_INCREMENT=1;

INSERT INTO `t_member` (`email`,`pw`,`nickName`,`memberTel`,`memberGrade`)
VALUES
  ("tellus@yahoo.edu","FKK11URU7TC","Calista Hicks","010-1632-1860",0),
  ("adipiscing.ligula@hotmail.ca","OKI10BEW8RH","Cullen Burgess","010-3817-0821",0),
  ("nulla@protonmail.org","MGU19LEN0VV","Amir Bruce","010-0803-8283",0),
  ("vulputate.nisi.sem@protonmail.org","WMG71CFL2UX","Barrett Bell","010-0273-7816",0),
  ("sit.amet@icloud.edu","RMX21VOO3CF","Clarke Reed","010-6225-7775",2),
  ("tortor.at@protonmail.org","UDM85WPP0XR","Dillon Matthews","010-7267-4426",0),
  ("aliquet@icloud.org","XKZ17TOA2XM","Zeph Mathis","010-3697-1150",1),
  ("phasellus.nulla@outlook.edu","LVE36SWO4NO","Selma Hurley","010-1374-8881",1),
  ("suscipit.nonummy@aol.com","BFE83ENQ5WL","Desiree Holden","010-5020-5202",0),
  ("a.ultricies.adipiscing@google.couk","MCJ71TSK4QI","Audra Davis","010-1536-2403",0);
INSERT INTO `t_member` (`email`,`pw`,`nickName`,`memberTel`,`memberGrade`)
VALUES
  ("pede.sagittis@hotmail.com","ORE58YOA4RB","Justina Merrill","010-0912-2737",1),
  ("consectetuer@yahoo.couk","GSB67RMH4QW","Skyler Sears","010-5171-8524",1),
  ("et.euismod@hotmail.org","OEW30BPE8OU","Ivy Chandler","010-4765-8679",1),
  ("ante.ipsum@yahoo.com","YFD13BVC9QG","Rigel Ford","010-1587-2528",0),
  ("convallis.erat.eget@icloud.com","HWA93USF8JX","Sean Orr","010-1544-6423",1),
  ("mus@outlook.ca","HVQ41HMJ8SS","Margaret Downs","010-4145-1008",1),
  ("mattis@protonmail.ca","GXB97FCH0XF","Ronan Elliott","010-0063-8962",1),
  ("tellus.non@yahoo.com","KWU17EDI5YD","Aladdin Gibbs","010-1228-4577",0),
  ("montes.nascetur.ridiculus@hotmail.com","MSY05CKS5HV","Brenda Ortega","010-3310-3909",1),
  ("sagittis.nullam.vitae@hotmail.com","JPJ53EKR6FU","Hannah Rutledge","010-8844-0877",1);
INSERT INTO `t_member` (`email`,`pw`,`nickName`,`memberTel`,`memberGrade`)
VALUES
  ("nam@yahoo.edu","JIH18UCC3PU","Aileen Roth","010-4710-1212",0),
  ("nullam.suscipit@outlook.ca","HVC37QEU1RC","Cassidy Bond","010-8740-8811",1),
  ("tempor@icloud.ca","JPT82FSN6XF","Wynter Gregory","010-2212-4423",1),
  ("netus.et.malesuada@protonmail.ca","VXS97ZOX5YS","Freya Santos","010-3796-5672",1),
  ("suspendisse.sed@icloud.com","MQM76DIN4QK","Leah Knowles","010-6634-8859",1),
  ("sapien.cursus@protonmail.ca","URJ13CKC3KQ","Quon Hurley","010-3772-1349",2),
  ("mi.lacinia.mattis@icloud.org","QXL44MUM2WG","Daniel Dillard","010-2450-1121",0),
  ("euismod@protonmail.edu","GGW61GFO2KS","Ross Fulton","010-1999-4789",2),
  ("ridiculus.mus@google.com","IVO26WLE3VN","Amery Kim","010-4127-5772",2),
  ("nibh.phasellus@yahoo.net","BCI55CIB7FM","Randall Hale","010-6876-3543",1);
INSERT INTO `t_member` (`email`,`pw`,`nickName`,`memberTel`,`memberGrade`)
VALUES
  ("elit.fermentum@hotmail.net","FBJ78ZLH4ZO","Alana Villarreal","010-4201-7014",0),
  ("mus.donec@outlook.edu","GYC13ZEI5DH","Aaron Mueller","010-7443-8673",1),
  ("dictum.eu.eleifend@protonmail.com","FPG73VSI3FG","Zachery Blevins","010-8121-4841",1),
  ("egestas@icloud.couk","RAB72XYI6RA","Porter Thornton","010-0077-0847",0),
  ("eget.volutpat.ornare@protonmail.com","JVA77GAN0QL","Michelle Little","010-5100-1483",1),
  ("mauris.nulla.integer@protonmail.com","KOQ96JQM2KS","Deacon Buckley","010-9593-1416",1),
  ("vivamus.sit@yahoo.edu","OFS73NBC4QJ","Nolan Mitchell","010-8165-5725",0),
  ("mauris@google.com","REJ57JSK6NT","Sybill Todd","010-6758-1151",0),
  ("vel@hotmail.org","EMU22RSE6PF","Timothy Hayes","010-2541-4293",2),
  ("at@protonmail.edu","DNU38HFR2SW","Darius Beach","010-6628-4433",0);
INSERT INTO `t_member` (`email`,`pw`,`nickName`,`memberTel`,`memberGrade`)
VALUES
  ("nisi.dictum.augue@outlook.edu","OXI43DFI5ML","Gabriel Mckinney","010-1256-2855",1),
  ("faucibus@icloud.com","WUQ41OSP1RP","Demetrius Riley","010-6795-2135",1),
  ("eu.ultrices@protonmail.edu","DTI30IOP6RV","Eleanor Davenport","010-2653-5157",1),
  ("fusce.mollis.duis@yahoo.org","ZHS03LPD4BQ","Fulton Mercado","010-5817-6566",1),
  ("sem.nulla.interdum@google.net","EEU01YJX2HY","Nelle Ashley","010-1579-0144",2),
  ("integer.tincidunt.aliquam@aol.couk","IIU11CRG2FP","Fulton Duncan","010-7738-7342",0),
  ("integer@google.net","YXG27CSX7ZX","Karly Benson","010-2633-5510",1),
  ("faucibus.ut@aol.org","QFW26KDP2EE","Declan Talley","010-0272-3921",1),
  ("nec.ante@outlook.com","DYQ47TNO6RF","Victor Holden","010-7735-7121",2),
  ("auctor.ullamcorper@google.ca","IPG65FLI3SR","Howard Rodriguez","010-2946-3481",0);
INSERT INTO `t_member` (`email`,`pw`,`nickName`,`memberTel`,`memberGrade`)
VALUES
  ("augue.id@aol.ca","JWH55SAT1OB","Ira Kirkland","010-1910-4333",1),
  ("aliquet.sem@icloud.couk","RFS50EXT6KM","Lillith White","010-6844-3602",0),
  ("non.nisi@protonmail.ca","HQS46XSZ0JD","Katelyn Norman","010-8437-1486",2),
  ("est.vitae@yahoo.com","SDM38QVD1BS","Dominic Giles","010-5349-6355",0),
  ("et@icloud.net","BPN26JIT6TE","TaShya Mcknight","010-0163-3324",0),
  ("id.mollis@icloud.com","GLM63SBV8PI","Gemma Tillman","010-8133-5981",1),
  ("magna.a@aol.edu","HQV60WCU4UN","Iona Medina","010-4675-1073",1),
  ("non@google.ca","HAW34TZX4NE","Francesca Clark","010-6884-8187",0),
  ("at.risus@icloud.net","RMO09NXL6ME","Amanda Mcmillan","010-5462-4727",1),
  ("ipsum@icloud.couk","QSQ02KQO4US","Samuel Sweeney","010-2648-6440",2);
INSERT INTO `t_member` (`email`,`pw`,`nickName`,`memberTel`,`memberGrade`)
VALUES
  ("curabitur@aol.edu","PJH74HXP7MO","Ursa Gutierrez","010-0112-7412",1),
  ("lacus.aliquam.rutrum@yahoo.com","SOM53WNS0DG","Maisie Garcia","010-2367-0777",1),
  ("sit.amet@google.couk","JXY61SNS1GU","Emery Snider","010-7353-2424",1),
  ("congue.elit.sed@protonmail.ca","YEI54KCC8FP","Lareina Martinez","010-7178-8576",0),
  ("maecenas.malesuada@hotmail.net","LED41TPZ2MM","Kasper Mcbride","010-0605-9821",1),
  ("eget.ipsum.suspendisse@icloud.edu","MXV27LIF9NU","Cameron Haley","010-2900-1485",1),
  ("consectetuer.ipsum@icloud.couk","SCM20EBE4VX","Clark Cole","010-6899-5378",1),
  ("in.tincidunt@hotmail.edu","XSM22DGB8CH","Brianna Anderson","010-8653-5152",1),
  ("pellentesque.ut@outlook.edu","IEN72NHO1IX","Yoshi Richards","010-8597-8256",1),
  ("hendrerit.neque.in@yahoo.edu","YHI68ECV0FW","Michelle Wells","010-7970-6144",1);
INSERT INTO `t_member` (`email`,`pw`,`nickName`,`memberTel`,`memberGrade`)
VALUES
  ("integer.mollis.integer@aol.ca","XOU27IUJ3WV","Elizabeth Durham","010-9917-8836",2),
  ("nunc.lectus@hotmail.org","LDN66SIJ6CH","Caleb Ramsey","010-8195-7355",1),
  ("maecenas.iaculis.aliquet@hotmail.ca","ESW82XTN4TR","Hall Compton","010-7951-8842",1),
  ("phasellus.in@hotmail.com","YQK33FEF8FM","Norman Alexander","010-4885-0661",1),
  ("erat@yahoo.couk","SGR47CSR7TQ","Jermaine Cohen","010-1426-5449",2),
  ("tristique.senectus.et@google.edu","MAK37CIC5YG","Jason Slater","010-2796-4525",2),
  ("luctus.et@yahoo.couk","LPO29ZTI0NC","Yoshi Bryan","010-1687-2472",1),
  ("nullam.enim@yahoo.ca","OIV54IPX3OT","Harlan Bray","010-8158-1507",1),
  ("id.nunc.interdum@yahoo.net","FCV22EUJ0KV","Desirae West","010-6727-4456",1),
  ("luctus.aliquet@google.edu","KPW45EAK5XW","MacKenzie Mack","010-0620-8143",1);
INSERT INTO `t_member` (`email`,`pw`,`nickName`,`memberTel`,`memberGrade`)
VALUES
  ("mollis.duis@google.net","HVR35NAO1MP","Sasha Rogers","010-7116-7136",1),
  ("et@aol.net","CIN52GUJ1RB","Dacey Dawson","010-4087-3501",0),
  ("tristique.senectus@hotmail.com","QFS45UQE9EE","Barbara Stevenson","010-6212-9267",1),
  ("ipsum.phasellus@icloud.ca","QBY98PQA1NJ","Natalie Boyd","010-1781-5549",0),
  ("magnis.dis@google.com","XDP45MCU9MM","Lars Crane","010-3513-7558",2),
  ("ipsum@hotmail.couk","ECB64OFB2TX","Adara Hoffman","010-7343-4532",2),
  ("nec.enim.nunc@aol.edu","TJM77TNM4MO","Vera Trujillo","010-1627-8637",2),
  ("quisque.tincidunt.pede@yahoo.edu","TRD28DIW4FL","Serina Gallagher","010-7293-2668",1),
  ("sem.molestie@hotmail.com","NUG15SHS1FJ","Benjamin Blevins","010-4494-3074",2),
  ("cum@google.couk","MQB21DKM9GQ","Belle Weiss","010-3364-1113",1);
INSERT INTO `t_member` (`email`,`pw`,`nickName`,`memberTel`,`memberGrade`)
VALUES
  ("orci.consectetuer@icloud.edu","JON42QHN1JU","Darryl King","010-3955-2668",1),
  ("placerat.velit@outlook.ca","TXJ54RUU6FE","Natalie Fox","010-2104-7718",2),
  ("nec.tellus@yahoo.couk","OUL76GYX4OI","Desirae Fox","010-7575-0454",1),
  ("ipsum.non@protonmail.couk","BOP80KUD5DY","Macaulay Rosario","010-7247-5386",0),
  ("leo.vivamus@protonmail.ca","MJB11ZRC8AM","Wylie Bullock","010-4873-6745",0),
  ("aliquam@protonmail.net","PAC57IUC1DC","Marny Brooks","010-1765-7712",0),
  ("tempor.erat@outlook.ca","PBE22TCC1PF","Olga Boyle","010-9493-8311",1),
  ("egestas@icloud.edu","GCU43SXM8RY","Paki Harrell","010-7665-4777",2),
  ("ultricies.sem@protonmail.couk","KTC78XCO8FL","Macaulay Schneider","010-4533-3625",1),
  ("tempus.non.lacinia@yahoo.couk","PUG71EGY3PO","Felicia Bolton","010-9486-7865",0);
