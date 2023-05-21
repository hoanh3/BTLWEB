var data = [];

function add() {
  var ten_id = document.getElementById("tenId").value;
  var ten_ChuyenMuc = document.getElementById("tenChuyenMuc").value;
  var chuyen_mucCha = document.getElementById("chuyenMucCha").value;

  var item = {
    id: ten_id,
    ChuyenMuc: ten_ChuyenMuc,
    tenChuyenMucCha: chuyen_mucCha,
  };
  let index = data.findIndex((c) => c.id == item.id);
  if (index >= 0) {
    data.splice(index, 1, item);
  } else {
    data.push(item);
  }

  render();
  clear();
}

console.log("a", data);

function render() {
  table = `
        <tr>
            <th>Id</th>
            <th>Tên chuyên chuyên mục</th>
            <th>Chuyên mục cha</th>  
            <th>Hành động</th>  
        </tr>
            `;
  for (let i = 0; i < data.length; i++) {
    table += `
            <tr>
                <th>${data[i].id}</th>
                <th>${data[i].ChuyenMuc}</th>
                <th>${data[i].tenChuyenMucCha}</th>
                <th>
                    <button onclick = "editItem(${data[i].id})" >Sửa</button> 
                    <button onclick = "deleteItem(${data[i].id})">Xóa</button>
                </th>
            </tr>
        `;
  }

  document.getElementById("render").innerHTML = table;
}
function clear() {
  document.getElementById("tenId").value = "";
  document.getElementById("tenChuyenMuc").value = "";
  document.getElementById("chuyenMucCha").value = "";
}
function deleteItem(x) {
  for (let i = 0; i < data.length; i++) {
    if (data[i].id == x) {
      data.splice(i, 1);
      render();
    }
  }
}
function editItem(x) {
  for (let i = 0; i < data.length; i++) {
    if (data[i].id == x) {
      document.getElementById("tenId").value = data[i].id;
      document.getElementById("tenDn").value = data[i].ChuyenMuc;
      document.getElementById("TenAdmin").value = data[i].tenChuyenMucCha;
    }
  }
}
