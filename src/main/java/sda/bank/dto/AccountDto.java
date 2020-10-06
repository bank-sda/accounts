package sda.bank.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class AccountDto {
    UUID id;
    String name;
    String type;
    String currency;
    BigDecimal value;
    Long owner;
}
