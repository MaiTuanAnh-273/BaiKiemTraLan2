package com.example.baikiemtralan2

import java.io.Serializable

data class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: String = "Chưa hoàn thành",
    var maCongViec: String = "CV001",
    var mucDoUuTien: String = "Trung bình"
) : Serializable {

    fun laDaHoanThanh(): Boolean {
        return trangThai == "Đã hoàn thành"
    }

    fun thongTinCongViec(): String {
        val trangThaiHienTai = if (laDaHoanThanh()) {
            "Đã hoàn thành"
        } else {
            "Chưa hoàn thành"
        }

        return "Mã công việc: $maCongViec\n" +
                "Tên công việc: $tenCongViec\n" +
                "Mô tả: $moTa\n" +
                "Mức độ ưu tiên: $mucDoUuTien\n" +
                "Trạng thái: $trangThaiHienTai"
    }
}