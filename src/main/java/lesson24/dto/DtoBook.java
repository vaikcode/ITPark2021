package lesson24.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class DtoBook {
    private String isbn;
    private String title;
    private String url;
    private Integer pageCount;
    private BigDecimal price;
}
