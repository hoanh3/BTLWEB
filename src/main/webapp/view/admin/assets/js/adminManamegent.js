var data = [];

function add() {
  var ten_id = document.getElementById("tenId").value;
  var ten_dn = document.getElementById("tenDn").value;
  var ten_admin = document.getElementById("tenAdmin").value;

  console.log(ten_id);
  console.log(ten_dn);
  console.log(ten_admin);

  var item = {
    id: ten_id,
    tenDangNhap: ten_dn,
    tenAdminSd: ten_admin,
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
            <th>Tên đăng nhập</th>
            <th>Tên admin</th>
            <th>Hành động</th>
        </tr>
            `;
  for (let i = 0; i < data.length; i++) {
    table += `
            <tr>
                <th>${data[i].id}</th>
                <th>${data[i].tenDangNhap}</th>
                <th>${data[i].tenAdminSd}</th>
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
  document.getElementById("tenDn").value = "";
  document.getElementById("password").value = "";
  document.getElementById("TenAdmin").value = "";
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
      document.getElementById("tenDn").value = data[i].tenDangNhap;
      document.getElementById("TenAdmin").value = data[i].tenAdminSd;
    }
  }
}
