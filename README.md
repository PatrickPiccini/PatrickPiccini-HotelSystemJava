# HotelSystem

No Codigo referente iremos abortar os seguintes conteudos:
- Bando de Dados SQLite
- Construtures
- Encapsulamento
- Enumeradores
- Exceptions
- Gravação de dados em arquivo .txt
- Herança
- Interface
- Orientação a objetos


Sistema de cadastro de cliente em um Hotel, mais a escolha do quarto e o nivel de luxo do mesmo.
Na navegação no sisitema existem 4 opções onde voce pode fazer a ação desejada.
No cadastro do cliente todas as informações serão gravas no banco de dados SQLite e em um arquivo .txt.
Para os dados de e-mail e cpf foram feitos validadores para a inserção da informaçõa correta.


Bibliotecas usadas:
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDateTime;


Criado por Patrick Berlatto Piccini©
