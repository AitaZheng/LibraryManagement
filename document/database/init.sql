CREATE TABLE book
(
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    author VARCHAR(50),
    total INT(11),
    lendCount INT(11),
    bookCount INT(11),
    categoryId INT(11),
    team_id INT(11) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id, team_id),
    CONSTRAINT fk_book_category1 FOREIGN KEY (categoryId) REFERENCES ,
    CONSTRAINT fk_book_team1 FOREIGN KEY (team_id) REFERENCES team (id)
);
CREATE INDEX fk_book_category1_idx ON book (categoryId);
CREATE INDEX fk_book_team1_idx ON book (team_id);
CREATE TABLE category
(
    id INT(11) NOT NULL AUTO_INCREMENT,
    parentId INT(11),
    name VARCHAR(50),
    comment VARCHAR(45),
    team_id INT(11) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id, team_id),
    CONSTRAINT fk_category_category FOREIGN KEY (parentId) REFERENCES ,
    CONSTRAINT fk_category_team1 FOREIGN KEY (team_id) REFERENCES team (id)
);
CREATE INDEX fk_category_category_idx ON category (parentId);
CREATE INDEX fk_category_team1_idx ON category (team_id);
CREATE TABLE member
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    mail VARCHAR(50),
    passwd VARCHAR(45),
    name VARCHAR(50)
);
CREATE TABLE team
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    creator INT(11),
    comment VARCHAR(200),
    createTime DATETIME
);
CREATE TABLE teamMemberRelation
(
    id INT(11) NOT NULL AUTO_INCREMENT,
    team_id INT(11) NOT NULL,
    member_id INT(11) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id, team_id, member_id),
    CONSTRAINT fk_group_has_member_group1 FOREIGN KEY (team_id) REFERENCES team (id),
    CONSTRAINT fk_group_has_member_member1 FOREIGN KEY (member_id) REFERENCES member (id)
);
CREATE INDEX fk_group_has_member_group1_idx ON teamMemberRelation (team_id);
CREATE INDEX fk_group_has_member_member1_idx ON teamMemberRelation (member_id);