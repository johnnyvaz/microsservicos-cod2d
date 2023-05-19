//package br.com.cod2d.api.domain.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import java.util.Date;
//
//@Data
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "users")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(length = 16)
//    private Long id;
//    private Date creationDate;
//    private Date updateDate;
//    @Column(unique = true)
//    private String username;
//    private String password;
//    private String fullName;
//    @Column(unique = true)
//    private String email;
//
//    @ManyToOne
//    @JoinColumn(name = "funcao_id")
//    private Funcao funcao;
//
//    @OneToOne
//    @JoinColumn(name = "organization_id")
//    private Organization organization;
//
//}