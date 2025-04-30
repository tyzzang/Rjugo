package com.allbadgi.rjugo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class RjugoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RjugoApplication.class, args);
	}
	@Bean
	CommandLineRunner testConnection(DataSource dataSource) {
		return args -> {
			try (Connection conn = dataSource.getConnection()) {
				// 접속 URL 출력
				System.out.println("✔️ DB 연결 성공! URL: "
						+ conn.getMetaData().getURL());
				// 예: 테이블 개수 조회
				var rs = conn.createStatement()
						.executeQuery("SELECT COUNT(*) FROM region");
				if (rs.next()) {
					System.out.println("▶ region 테이블 row 수: "
							+ rs.getInt(1));
				}
			}
		};
	}
}
