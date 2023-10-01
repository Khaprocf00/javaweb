USE javaweb;
CREATE TABLE slider(
	id BIGINT NOT NULL PRIMARY KEY auto_increment,
	NAME  VARCHAR(255) NOT NULL, 
	image  VARCHAR(255) NOT NULL,
	content Text NOT NULL,
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);
CREATE TABLE ROLE(
	id BIGINT NOT NULL PRIMARY KEY auto_increment,
	name  VARCHAR(255) NOT NULL, 
	code  VARCHAR(255) NOT NULL,
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);

CREATE TABLE tag(
	id BIGINT NOT NULL PRIMARY KEY auto_increment,
	name  VARCHAR(255) NOT NULL, 
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);
CREATE TABLE image(
	id BIGINT NOT NULL PRIMARY KEY auto_increment,
	product_id  BIGINT NOT NULL,
	path  VARCHAR(255) NOT NULL, 
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);
CREATE TABLE category(
	id BIGINT NOT NULL PRIMARY KEY auto_increment,
	name  VARCHAR(255) NOT NULL, 
	code  VARCHAR(255) NOT NULL,
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);
CREATE TABLE brand(
	id BIGINT NOT NULL PRIMARY KEY auto_increment,
	name  VARCHAR(255) NOT NULL, 
	code  VARCHAR(255) NOT NULL,
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);
CREATE TABLE color(
	id BIGINT NOT NULL PRIMARY KEY auto_increment,
	name  VARCHAR(255) NOT NULL, 
	code  VARCHAR(255) NOT NULL,
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);
CREATE TABLE product(
	id BIGINT NOT NULL PRIMARY KEY auto_increment,
	qty INT NOT NULL ,
	price double NOT NULL,
	discount DOUBLE NOT NULL,
	category_id BIGINT NOT NULL,
	brand_id BIGINT NOT NULL,
	tag_id BIGINT NOT NULL,
	slider_id BIGINT NOT NULL,
	name  VARCHAR(255) NOT NULL, 
	shortdescription  VARCHAR(255) NOT NULL, 
	sku  VARCHAR(255) NOT NULL, 
	image_path  VARCHAR(255) NOT NULL, 
	content  Text NOT NULL, 
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);
CREATE TABLE product_detail(
	id BIGINT NOT NULL PRIMARY KEY auto_increment,
	product_id BIGINT NOT NULL,
	color_id BIGINT NOT NULL,
	size_id BIGINT NOT NULL,
	qty INT NOT NULL,
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);
CREATE TABLE size(
	id BIGINT NOT NULL PRIMARY KEY auto_increment,
	name  VARCHAR(255) NOT NULL, 
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);
CREATE TABLE user(
	id BIGINT NOT NULL PRIMARY KEY auto_increment,
	email  VARCHAR(255) NOT NULL, 
	username  VARCHAR(255) NOT NULL, 
	password  VARCHAR(255) NOT NULL, 
	role_id BIGINT not null ,
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);
ALTER TABLE image ADD CONSTRAINT fk_user_role FOREIGN KEY (role_id) REFERENCES role(id);
--add foreign key
ALTER TABLE image ADD CONSTRAINT fk_image_product FOREIGN KEY (product_id) REFERENCES product(id);
ALTER TABLE product ADD CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES category(id);
ALTER TABLE product ADD CONSTRAINT fk_product_brand FOREIGN KEY (brand_id) REFERENCES brand(id);
ALTER TABLE product ADD CONSTRAINT fk_product_tag FOREIGN KEY (tag_id) REFERENCES tag(id);
ALTER TABLE product ADD CONSTRAINT fk_product_slider FOREIGN KEY (slider_id) REFERENCES slider(id);
ALTER TABLE product_detail ADD CONSTRAINT fk_productdetail_size FOREIGN KEY (size_id) REFERENCES size(id);
ALTER TABLE product_detail ADD CONSTRAINT fk_productdetail_color FOREIGN KEY (color_id) REFERENCES color(id);
ALTER TABLE product_detail ADD CONSTRAINT fk_productdetail_product FOREIGN KEY (product_id) REFERENCES product(id);
