package db.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.persistence.Entity;

@Data
@Entity
@Table(name = "result")
@NoArgsConstructor
public class ResultApi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "input_data")
    private String inputData;
    @Column(name = "output_data")
    private String outputData;
    @Column(name = "status_code")
    private Integer statusCode;
    @Column(name = "status_test")
    private String statusTest;
    @Column(name = "exception_message")
    private String exceptionMessage;
}
