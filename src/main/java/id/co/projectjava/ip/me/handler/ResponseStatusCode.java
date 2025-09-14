package id.co.projectjava.ip.me.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseStatusCode {
    // Generic Error
    E_GENERIC_ERROR("89999", 500, "Internal server error", "Unmapped internal server error"),
    // Success
    SUCCESS("00000", 200, "Success", "Success"),
    // Error
    E_TIDAK_DAPAT_DIPROSES("80001", 400, "Permintaan tidak dapat diproses", "Kami akan melakukan pengecekan terlebih dahulu. Silakan kembali beberapa saat lagi"),
    E_PERMINTAAN_GAGAL("80003", 400, "Permintaan gagal", "Gagal untuk membaca data"),
    // Business
    B_PERMINTAAN_GAGAL("40001", 400, "Permintaan gagal", "Data belum bisa ditemukan"),
    B_DATA_GAGAL_DISIMPAN("0002", 400, "Data gagal disimpan", "Validasi data tidak berhasil")
    ;

    private final String code;
    private final int htttpCode;
    private final String title;
    private final String desc;
}
