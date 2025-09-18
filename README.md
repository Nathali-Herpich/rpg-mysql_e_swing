# 🖥️ Integração de Java Swing com MySQL

Este guia mostra como criar uma aplicação desktop simples usando **Java Swing** para a interface gráfica e **MySQL** como banco de dados relacional.

---

## 📦 Pré-requisitos

- Java JDK instalado
- MySQL Server em execução
- Driver JDBC (MySQL Connector/J)
- IDE como IntelliJ, Eclipse ou NetBeans

---

## 🛠️ Etapas de Desenvolvimento

### 1. Criar o Banco de Dados MySQL

```sql
CREATE DATABASE cadastro;

USE cadastro;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100)
);
