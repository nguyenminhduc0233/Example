<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Custom Table with jqGrid</title>
  <style>
    /* Tổng thể bảng */
    table {
      width: 100%;
      margin: 20px auto;
      border-collapse: collapse;
    }

    /* Header */
    th {
      background-color: #4CAF50;
      color: white;
      text-align: center;
      padding: 10px;
    }

    /* Dòng dữ liệu */
    td {
      text-align: center; /* Canh giữa nội dung */
      padding: 10px;
      border: none; /*Loại bỏ viền giữa các ô */
    }

    /* Xen kẽ màu cho các hàng */
    tr:nth-child(odd) {
      background-color: #b83030; /* Màu cho hàng lẻ */
    }

    tr:nth-child(even) {
      background-color: #ffffff; /* Màu cho hàng chẵn */
    }

    /* Checkbox */
    th input[type="checkbox"],
    td input[type="checkbox"] {
      transform: scale(1.2); /* Phóng to checkbox */
    }

    /* Liên kết */
    td a {
      color: #007BFF;
      text-decoration: none;
    }

    /* Liên kết khi hover */
    td a:hover {
      text-decoration: underline;
    }
  </style>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/jquery-ui-dist/jquery-ui.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/free-jqgrid/dist/css/ui.jqgrid.min.css">
</head>
<body>
  <table id="a"></table>

  <script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/jquery-ui-dist/jquery-ui.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/free-jqgrid/dist/jquery.jqgrid.min.js"></script>
  <script>
    $(document).ready(function () {
      $("#a").jqGrid({
        datatype: "local",
        colNames: [
          '<input type="checkbox" id="headerCheckbox" />', // Header checkbox với id
          "Links Column" // Cột link
        ],
        colModel: [
          {
            name: "checkbox",
            index: "checkbox",
            width: 60,
            align: "center",
            sortable: false,
            formatter: function () {
              return '<input type="checkbox" class="rowCheckbox" />'; // Checkbox trong cột
            }
          },
          {
            name: "linkColumn",
            index: "linkColumn",
            width: 300,
            formatter: function (cellvalue) {
              return (
                '<div class="abc"></div>' + // Thẻ div phía trước
                '<a href="' + cellvalue.url + '" target="_blank">' +
                cellvalue.text +
                "</a>"
              );
            }
          }
        ],
        data: [
          {
            checkbox: "",
            linkColumn: { url: "https://example.com", text: "Example Link" }
          },
          {
            checkbox: "",
            linkColumn: { url: "https://another.com", text: "Another Link" }
          }
        ],
        rowNum: 1000, // Hiển thị tất cả bản ghi trong bảng (giá trị lớn hơn tổng số bản ghi)
        viewrecords: false, // Không hiển thị số bản ghi
        pager: null, // Không hiển thị thanh phân trang
        caption: "", // Không hiển thị tiêu đề bảng
        loadComplete: function () {
          // Đảm bảo bảng không có viền giữa các ô khi render xong
          $(".ui-jqgrid .ui-jqgrid-btable tr").css("border", "none");
        }
      });
    });
  </script>
</body>
</html>
