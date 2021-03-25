function getAllStudents() {
    $.ajax({
        method: "GET",
        url: 'http://localhost:8080/api/students'
    }).done(function(data) {
        $('#tdata').empty();
        $.each(data, function(i, students) {
            // Loading data into table
            $('#tdata')
                .append($("<tr>"))
                .append($("<input type=\"text\" class=\"form-control\">").val(students.studentId))
                //.append($("</td>"))
                .append($("<td>"))
                .append($("<input type=\"text\" class=\"form-control\">").val(students.firstName))
                //.append($("</td>"))
                .append($("<td>"))
                .append($("<input type=\"text\" class=\"form-control\">").val(students.lastName))
                //.append($("</td>"))
                .append($("<td>"))
                .append($("<input type=\"text\" class=\"form-control\">").val(students.email))
                //.append($("</td>"))
                .append($("<td>"))
                //.append($("</td>"))
                .append($("<td>"))
                .append($("<button type='button' class='btn btn-primary' onclick=\"updateStudent(" + students.studentId + ")\">Update</button>"))
                //.append($("</td>"))
                .append($("<td>"))
                .append($("<button type='button' class='btn btn-danger' onclick=\"deleteStudent(" + students.studentId + ")\">Delete</button>"))
                .append($("</td>"));
        });
    })
}



$(document).ready(function() {
    getAllStudents();

});