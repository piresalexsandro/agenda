CREATE TABLE estudos.`agenda` (
 `id` 					bigint(20) NOT NULL AUTO_INCREMENT,
 `nome` 				varchar(100) DEFAULT NULL,
 `email` 				varchar(100) DEFAULT NULL,
 `telefone` 			bigint(20) DEFAULT NULL,
 `data_cadastro` 		timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 `logradouro` 			varchar(50) DEFAULT NULL,
 `numero_residencia` 	int(5) DEFAULT NULL,
 `bairro` 				varchar(50) DEFAULT NULL,
 `cidade` 				varchar(50) DEFAULT NULL,
 `estado` 				varchar(30) DEFAULT NULL,
 `uf` 					char(2) DEFAULT NULL,
 `cep` 					int(8) DEFAULT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;