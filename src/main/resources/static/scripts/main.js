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

                .append($("<td>"))
                .append($("<input type=\"text\" class=\"form-control\">").val(students.firstName))

                .append($("<td>"))
                .append($("<input type=\"text\" class=\"form-control\">").val(students.lastName))

                .append($("<td>"))
                .append($("<input type=\"text\" class=\"form-control\">").val(students.email))
                .append($("<td>"))

                .append($("<input type=\"text\" class=\"form-control\">").val(students.supervisor.supervisorId))
                .append($("<td>"))

                .append($("<td>"))
                .append($("<button type='button' class='btn btn-primary' onclick=\"updateStudent(" + students.studentId + ")\">Update</button>"))

                .append($("<td>"))
                .append($("<button type='button' class='btn btn-danger' onclick=\"deleteStudent(" + students.studentId + ")\">Delete</button>"))
                .append($("</td>"));
        });
    })
}

// Get all Supervisors
function supervisorDropdown() {
    $.ajax({
        method: "GET",
        url: 'http://localhost:8080/api/supervisors'
    }).done(function (data) {
        $('#cdata').empty();

        $.each(data, function (i, supervisor) {
            $('#cdata')
                .append($("<option></option>")
                    .text(supervisor.supervisorId + " " + supervisor.lastName));
        })
    })
}

// Create a new student
function createStudent() {

    let student = {};
    let supervisor = {};
    let dynamicURL = "";
    let methodName = "";

    $('#btnAddStudent').click(function() {
        student.firstName = $('#firstname').val();
        student.lastName = $('#lastname').val();
        student.email = $('#email').val();
        let temp = $("#cdata option:selected").text();
        let supervisorIdTemp = temp.substr(0, 1);
        supervisor.supervisorId = supervisorIdTemp;
        student.supervisor = supervisor;
        console.log(temp);
        console.log(supervisor.supervisorId);
        dynamicURL = "http://localhost:8080/api/newStudent/";
        methodName = "POST";
        let studentObj = JSON.stringify(student);
        console.log(studentObj);
        $.ajax({
            url: "http://localhost:8080/api/newStudent/",
            method: "POST",
            contentType: 'application/JSON',
            data: JSON.stringify(student),
            success: function() {
                getAllStudents();
            },
            error: function(error) {
                alert(error);
            }
        })
    })
}

function updateStudent(id) {
    let student = {};
    let supervisor = {};

    $( ".form-control" ).each(function(index) {
        if (Number($( this ).val()) === (id)){
            student.firstName = $(`.form-control:eq(${index +1})`).val();
            student.lastName = $(`.form-control:eq(${index +2})`).val();
            student.email = $(`.form-control:eq(${index +3})`).val();
            student.supervisor = supervisor;
            student.supervisor.supervisorId = $(`.form-control:eq(${index +4})`).val();
            console.log(JSON.stringify(student));
            console.log("After");
        }
    });
    $.ajax({
        url: 'http://localhost:8080/api/update/' + id,
        method: 'PUT',
        dataType: 'json',
        contentType: 'application/JSON',
        data: JSON.stringify(student),
        success: function(data) {
            console.log(JSON.stringify(data))
            getAllStudents();
        },
        error: function(error) {
            alert(error)
        }

    })
}

function deleteStudent(id) {
    console.log(id)
    $.ajax({
        url: 'http://localhost:8080/api/deleteStudent/' + id,
        method: 'DELETE',
        success: function() {
            getAllStudents();
        },
        error: function(error) {
            alert(error);
        }
    })
}

$(document).ready(function() {
    getAllStudents();
    supervisorDropdown()
    createStudent();
});