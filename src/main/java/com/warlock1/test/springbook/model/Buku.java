package com.warlock1.test.springbook.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

//@EntityListeners(AuditingEntityListener.class) //merupakan entity dari JPA yang digunakan untuk meng-update data
//@Table(name = "Buku") // digunakan untuk membuat table baru dengan nama “books”
//@JsonIgnoreProperties(value = { "createAt","updateAt"}, allowGetters = true) //digunakan agar data pada variable tersebut tidak bisa dimasukan secara manual
@Data
@Entity
public class Buku {

    @Id //d igunakan untuk memdefinisikan primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_buku")
    private Long id;

    @Column(name = "title_book")
    @NotBlank
    private String titleBook;

    @Column(name = "nama_depan_pengarang")
    @NotBlank //digunakan agar isi pada field nya NOT NULL
    private String namaDepanPengarang;

    @Column(name = "nama_belakang_pengarang")
    @NotBlank
    private String namaBelakangPengarang;

    @Column(name = "status_peminjaman")
    @NotBlank
    private Integer statusPeminjaman;

    @Column(name = "nama_peminjam")
    @NotBlank
    private String namaPeminjam;

    @Column(nullable = false, updatable = false, name = "created_at")
//    @Temporal (TemporalType.TIMESTAMP) //digunakan untuk merubah data berupa tanggal dan waktu dari database dan ke database
    @CreatedDate // digunakan untuk mendapatkan waktu dibuatnya data
    private Date createdAt;

    @Column(nullable = false, name = "updated_at")
//    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate  //digunakan untuk mendapatkan waktu terakhir data diedit
    private Date updatedAt;
//
//
//    // Getter and Setter
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getTitleBook() {
//        return titleBook;
//    }
//
//    public String getNamaDepanPengarang() {
//        return namaDepanPengarang;
//    }
//
//    public String getNamaBelakangPengarang() {
//        return namaBelakangPengarang;
//    }
//
//    public int getStatusPeminjaman() {
//        return statusPeminjaman;
//    }
//
//    public String getNamaPeminjam() {
//        return namaPeminjam;
//    }
//
//    public Date getCreatedAt() {
//        return createdAt;
//    }
//
//    public Date getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setTitleBook(String titleBook) {
//        this.titleBook = titleBook;
//    }
//
//    public void setNamaDepanPengarang(String namaDepanPengarang) {
//        this.namaDepanPengarang = namaDepanPengarang;
//    }
//
//    public void setNamaBelakangPengarang(String namaBelakangPengarang) {
//        this.namaBelakangPengarang = namaBelakangPengarang;
//    }
//
//    public void setStatusPeminjaman(int statusPeminjaman) {
//        this.statusPeminjaman = statusPeminjaman;
//    }
//
//    public void setNamaPeminjam(String namaPeminjam) {
//        this.namaPeminjam = namaPeminjam;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public void setUpdatedAt(Date updatedAt) {
//        this.updatedAt = updatedAt;
//    }
}
