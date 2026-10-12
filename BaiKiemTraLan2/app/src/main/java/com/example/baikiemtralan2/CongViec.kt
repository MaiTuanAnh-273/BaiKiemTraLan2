package com.example.baikiemtralan2

import java.io.Serializable

class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: String = "Chưa hoàn thành"
) : Serializable {

    fun thongTinCongViec(): String {
        return "Tên công việc: $tenCongViec\n" +
                "Mô tả: $moTa\n" +
                "Trạng thái: $trangThai"
    }
}