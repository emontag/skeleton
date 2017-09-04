CREATE TABLE receipts (
  id INT UNSIGNED AUTO_INCREMENT,
  uploaded TIME DEFAULT CURRENT_TIME(),
  merchant VARCHAR(255),
  amount DECIMAL(12,2),
  receipt_type INT UNSIGNED,

  PRIMARY KEY (id)
);
CREATE TABLE receiptTag(
  id INT UNSIGNED,
  receipt_tag VARCHAR(255),
  PRIMARY KEY (id, receipt_tag)
);