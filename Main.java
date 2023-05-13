/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadwalmatakuliah;

/**
 *
 * @author alfia
 */
import java.util.Scanner;

interface Data {
  void inputData();
  void editData();
  void hapusData();
  void tampilData();
}

abstract class MataKuliah implements Data {
  protected String nama;
  protected int sks;

  public MataKuliah(String nama, int sks) {
    this.nama = nama;
    this.sks = sks;
  }

  public void tampilData() {
    System.out.println("Nama Mata Kuliah: " + nama);
    System.out.println("Jumlah SKS: " + sks);
  }
}

class Teori extends MataKuliah {
  protected String dosen;
  protected String ruangan;

  public Teori(String nama, int sks, String dosen, String ruangan) {
    super(nama, sks);
    this.dosen = dosen;
    this.ruangan = ruangan;
  }

  public void inputData() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Masukkan Nama Mata Kuliah: ");
    nama = sc.nextLine();
    System.out.print("Masukkan Jumlah SKS: ");
    sks = sc.nextInt();
    sc.nextLine();
    System.out.print("Masukkan Nama Dosen: ");
    dosen = sc.nextLine();
    System.out.print("Masukkan Nama Ruangan: ");
    ruangan = sc.nextLine();
    System.out.println("Data telah ditambahkan.");
  }

  public void editData() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Masukkan Nama Mata Kuliah yang akan diubah: ");
    String namaMK = sc.nextLine();
    if (nama.equals(namaMK)) {
      System.out.print("Masukkan Nama Dosen Baru: ");
      dosen = sc.nextLine();
      System.out.print("Masukkan Nama Ruangan Baru: ");
      ruangan = sc.nextLine();
      System.out.println("Data telah diubah.");
    } else {
      System.out.println("Data tidak ditemukan.");
    }
  }

  public void hapusData() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Masukkan Nama Mata Kuliah yang akan dihapus: ");
    String namaMK = sc.nextLine();
    if (nama.equals(namaMK)) {
      nama = "";
      sks = 0;
      dosen = "";
      ruangan = "";
      System.out.println("Data telah dihapus.");
    } else {
      System.out.println("Data tidak ditemukan.");
    }
  }

  public void tampilData() {
    System.out.println("Data Mata Kuliah Teori:");
    super.tampilData();
    System.out.println("Nama Dosen: " + dosen);
    System.out.println("Nama Ruangan: " + ruangan);
  }
}

class Praktikum extends MataKuliah {
  protected int lab;

  public Praktikum(String nama, int sks, int lab) {
    super(nama, sks);
    this.lab = lab;
  }

  public void inputData() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Masukkan Nama Mata Kuliah: ");
    nama = sc.nextLine();
    System.out.print("Masukkan Jumlah SKS: ");
    sks = sc.nextInt();
    sc.nextLine();
    System.out.print("Masukkan Nomor Laboratorium: ");
    lab = sc.nextInt();
    System.out.println("Data telah ditambahkan.");
  }

  public void editData() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Masukkan Nama Mata Kuliah yang akan diubah: ");
    String namaMK = sc.nextLine();
    if (nama.equals(namaMK)) {
      System.out.print("Masukkan Nomor Laboratorium Baru: ");
      lab = sc.nextInt();
      System.out.println("Data telah diubah.");
    } else {
      System.out.println("Data tidak ditemukan.");
    }
  }

  public void hapusData() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Masukkan Nama Mata Kuliah yang akan dihapus: ");
    String namaMK = sc.nextLine();
    if (nama.equals(namaMK)) {
      nama = "";
      sks = 0;
      lab = 0;
      System.out.println("Data telah dihapus.");
    } else {
      System.out.println("Data tidak ditemukan.");
    }
  }

  public void tampilData() {
    System.out.println("Data Mata Kuliah Praktikum:");
    super.tampilData();
    System.out.println("Nomor Laboratorium: " + lab);
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    MataKuliah[] jadwal = new MataKuliah[10];
    int count = 0;
    int pilih;
    do {
      System.out.println("\n==== MENU UTAMA ====");
      System.out.println("Alfian Bayu Nur Aji");
      System.out.println("211011400155");
      System.out.println("04TPLE001");
      System.out.println("=====================");
      System.out.println("1. Input Data");
      System.out.println("2. Edit atau Hapus Data");
      System.out.println("3. Menampilkan Data");
      System.out.println("4. Keluar");
      System.out.print("Masukkan Pilihan: ");
      pilih = sc.nextInt();

      switch (pilih) {
      case 1:
        System.out.println("\n=== INPUT DATA ===");
        System.out.println("1. Mata Kuliah Teori");
        System.out.println("2. Mata Kuliah Praktikum");
        System.out.print("Masukkan Pilihan: ");
        int pilihMK = sc.nextInt();
        sc.nextLine();

        if (pilihMK == 1) {
          jadwal[count] = new Teori("", 0, "", "");
          jadwal[count].inputData();
          count++;
        } else if (pilihMK == 2) {
          jadwal[count] = new Praktikum("", 0, 0);
          jadwal[count].inputData();
          count++;
        } else {
          System.out.println("Pilihan tidak valid.");
        }
        break;

      case 2:
        System.out.println("\n=== EDIT ATAU HAPUS DATA ===");
        System.out.println("1. Edit Data");
        System.out.println("2. Hapus Data");
        System.out.print("Masukkan Pilihan: ");
        int pilihEdit = sc.nextInt();
        sc.nextLine();
        System.out.print("Masukkan Nama Mata Kuliah yang akan diubah/hapus: ");
        String namaMK = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < count; i++) {
          if (jadwal[i].nama.equals(namaMK)) {
            found = true;
            if (pilihEdit == 1) {
              jadwal[i].editData();
            } else if (pilihEdit == 2) {
              jadwal[i].hapusData();
              for (int j = i; j < count - 1; j++) {
                jadwal[j] = jadwal[j + 1];
              }
              jadwal[count - 1] = null;
              count--;
            }
            break;
          }
        }
        if (!found) {
          System.out.println("Data tidak ditemukan.");
        }
        break;

      case 3:
        System.out.println("\n=== MENAMPILKAN DATA ===");
        for (int i = 0; i < count; i++) {
          jadwal[i].tampilData();
          System.out.println();
        }
        break;

      case 4:
        System.out.println("Program selesai.");
        break;

      default:
        System.out.println("Pilihan tidak valid.");
        break;
      }

    } while (pilih != 4);
  }

}