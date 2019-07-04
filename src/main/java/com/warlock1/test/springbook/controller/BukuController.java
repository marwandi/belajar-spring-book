package com.warlock1.test.springbook.controller;

import com.warlock1.test.springbook.model.Buku;
import com.warlock1.test.springbook.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buku")
public class BukuController {

    @Autowired
    BukuRepository bukuRepository;

    //Get All buku
    @GetMapping("/") //digunakan agar http request yang digunakan adalah GET
    public List<Buku> getAll() {
        return bukuRepository.findAll(); //digunakan agar me-return semua list buku
    }

    //Nambah Buku
    @PostMapping("/") //digunakan agar http request yang digunakan adalah POST
    public Buku tambahbuku(@Valid @RequestBody Buku buku) {    // valid digunakan agar isi ketika di post valid atau tidak ada yang kosong
        return bukuRepository.save(buku);
    }

    //update Buku
    @PutMapping("/{id}")
    public ResponseEntity<Buku> updateBuku(@PathVariable(value="id")Long id,@Valid @RequestBody Buku detailbuku) { //digunakan untuk mendapatkan data dari id ketika diketikan di url. Contoh http://localhost:8080/buku/1

        Optional<Buku> optionalBuku = bukuRepository.findById(id);
        //Buku buku = bukuRepository.findOne(id);
        Buku buku = new Buku();
        if(buku == null)
            return ResponseEntity.notFound().build();
        buku.setTitleBook(detailbuku.getTitleBook());
        buku.setNamaDepanPengarang(detailbuku.getNamaDepanPengarang());
        buku.setNamaBelakangPengarang(detailbuku.getNamaBelakangPengarang());
        buku.setNamaPeminjam(detailbuku.getNamaPeminjam());
        buku.setStatusPeminjaman(detailbuku.getStatusPeminjaman());
        Buku updateBuku = bukuRepository.save(buku);

        return ResponseEntity.ok(updateBuku);
    }

    //Delete Buku
    @DeleteMapping("/{id}")
    public String deleteBuku(@PathVariable (value = "id") Long id) {
        Optional<Buku> optionalBuku = bukuRepository.findById(id);
        //Buku buku = bukuRepository.findOne(id);
        Buku buku = new Buku();

        String result = "";

        if(buku == null) {
            result = "id"+id+"tidak ditemukan";

            return result;
        }

        result = "id"+id+"berhasil dihapus";
        bukuRepository.delete(buku);

        return result;

    }

    //Mendapatkan data by Id
    @GetMapping("/{id}")
    public ResponseEntity<Buku> getBukuById(@PathVariable(value = "id") Long id) {
        Optional<Buku> optionalBuku = bukuRepository.findById(id);
        //Buku buku = bukuRepository.findOne(id);
        Buku buku = new Buku();
        if(buku == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(buku);
    }

    //Sorting buku
    @GetMapping("/sortbuku")
    public List<Buku> sortbuku(@RequestParam(value="title")String titleBook){
        return bukuRepository.findByTitleBook(titleBook);
    }

    //Sorting buku by status peminjaman
    @GetMapping("/sortstatus/{statusPeminjaman}")
    public List<Buku> sortstatus(@PathVariable(value="statusPeminjaman") int statusPeminjaman){
        return bukuRepository.findByStatusPeminjaman(statusPeminjaman);
    }
}
