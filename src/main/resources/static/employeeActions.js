// Örnek JavaScript kodu
// Kaydetme işlemi için örnek bir fetch isteği
fetch('/v1/employee/save', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json',
    },
    body: JSON.stringify({
        // Gönderilecek veriler burada
        // Örneğin:
        name: 'John',
        surName: 'Doe',
        email: 'john@example.com',
        job: 'Developer',
        // ...
    }),
})
    .then(response => {
        // Yanıtla ilgili işlemler burada
        if (response.ok) {
            // Başarılı ise yapılacak işlemler
            console.log('Kayıt başarıyla eklendi.');
            // Sayfayı yenileme, yönlendirme vs.
        } else {
            // Başarısız ise yapılacak işlemler
            console.error('Bir hata oluştu.');
        }
    })
    .catch(error => {
        // Hata durumunda yapılacak işlemler
        console.error('İstek gönderilirken bir hata oluştu:', error);
    });



// employeeOperations.js

// Kaydetme işlemi için
function saveEmployee() {
    // Formdaki verileri al
    const name = document.getElementById('name').value;
    const surName = document.getElementById('surName').value;
    const email = document.getElementById('email').value;
    const job = document.getElementById('job').value;

    // POST isteği gönder
    fetch('/v1/employee/save', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            name,
            surName,
            email,
            job,
        }),
    })
        .then(response => {
            if (response.ok) {
                console.log('Çalışan başarıyla kaydedildi.');
                // Başarılı ise gerekli işlemler yapılabilir
                // Örneğin, sayfayı yenileme veya başka bir işlem
            } else {
                console.error('Bir hata oluştu.');
            }
        })
        .catch(error => {
            console.error('İstek gönderilirken bir hata oluştu:', error);
        });
}

// Silme işlemi için
function deleteEmployee(employeeId) {
    fetch(`/v1/employee/delete/${employeeId}`, {
        method: 'POST',
    })
        .then(response => {
            if (response.ok) {
                console.log('Çalışan başarıyla silindi.');
                // Başarılı ise gerekli işlemler yapılabilir
            } else {
                console.error('Bir hata oluştu.');
            }
        })
        .catch(error => {
            console.error('İstek gönderilirken bir hata oluştu:', error);
        });
}

// Güncelleme işlemi için
function updateEmployee(employeeId) {
    const updatedName = document.getElementById('updatedName').value;
    const updatedSurName = document.getElementById('updatedSurName').value;
    const updatedEmail = document.getElementById('updatedEmail').value;
    const updatedJob = document.getElementById('updatedJob').value;

    fetch('/v1/employee/update', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            id: employeeId,
            name: updatedName,
            surName: updatedSurName,
            email: updatedEmail,
            job: updatedJob,
        }),
    })
        .then(response => {
            if (response.ok) {
                console.log('Çalışan başarıyla güncellendi.');
                // Başarılı ise gerekli işlemler yapılabilir
            } else {
                console.error('Bir hata oluştu.');
            }
        })
        .catch(error => {
            console.error('İstek gönderilirken bir hata oluştu:', error);
        });
}

// Liste alma işlemi için
function getEmployeeList() {
    fetch('/v1/employee/findall')
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('İstek başarısız oldu.');
        })
        .then(data => {
            // Alınan verileri işleme
            console.log('Çalışanlar:', data);
            // Verileri kullanarak istenilen işlemler yapılabilir
        })
        .catch(error => {
            console.error('Veri alınırken bir hata oluştu:', error);
        });
}
