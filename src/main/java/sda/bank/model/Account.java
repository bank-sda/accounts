package sda.bank.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@Document("Accounts")
public class Account {
    @Id
    UUID id;
    String name;
    String type;
    String currency;
    BigDecimal value;
    Long owner;
}
