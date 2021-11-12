package ru.moore.AISUchetTehniki.models.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    @Email(message = "Некорректный E-mail")
    @NotBlank(message = "E-mail не может быть пустым")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @Column(name="password")
    @NotBlank(message = "Пароль не может быть пустым")
    private String password;

    @Column(name = "last_name")
    @NotBlank(message = "Фамилия не может быть пустым")
    private String lastName;

    @Column(name = "first_name")
    @NotBlank(message = "Имя не может быть пустым")
    private String firstName;

    @Column(name = "middle_names")
    private String middleNames;

    @Column(name = "confirmation_code")
    private String confirmationCode;

    @Column(name = "confirmation")
    private boolean confirmation;

    @Column(name = "global_id")
    private String globalId;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    @UpdateTimestamp
    private LocalDateTime updateAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}