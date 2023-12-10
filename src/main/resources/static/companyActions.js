// Company ekleme işlemi için
function registerCompany() {
    const companyName = 'ABC Company'; // Örnek veri, gerçek formdan alınmalı
    const companyAddress = 'İstanbul'; // Örnek veri, gerçek formdan alınmalı

    fetch('http://localhost:8080/v1/company/save', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            companyName: companyName,
            companyAddress: companyAddress
        })
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('Network response was not ok.');
        })
        .then(data => {
            console.log('Company registered:', data);
            // İşlem başarılıysa sayfayı yenile veya başka bir işlem yapabilirsiniz
        })
        .catch(error => {
            console.error('There has been a problem with your fetch operation:', error);
        });
}

// Tüm şirketleri listeleme işlemi için
function getAllCompanies() {
    fetch('http://localhost:8080/v1/company/findall', {
        method: 'POST'
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('Network response was not ok.');
        })
        .then(data => {
            console.log('All companies:', data);
            // Şirket listesini kullanarak frontend'de bir tablo oluşturabilir veya işlem yapabilirsiniz
        })
        .catch(error => {
            console.error('There has been a problem with your fetch operation:', error);
        });
}

// Şirket güncelleme işlemi için
function updateCompany() {
    const companyId = 1; // Örnek bir companyId
    const companyName = 'New ABC Company'; // Örnek veri, gerçek formdan alınmalı
    const companyAddress = 'Ankara'; // Örnek veri, gerçek formdan alınmalı

    fetch('http://localhost:8080/v1/company/update', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            id: companyId,
            companyName: companyName,
            companyAddress: companyAddress
        })
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('Network response was not ok.');
        })
        .then(data => {
            console.log('Company updated:', data);
            // İşlem başarılıysa sayfayı yenile veya başka bir işlem yapabilirsiniz
        })
        .catch(error => {
            console.error('There has been a problem with your fetch operation:', error);
        });
}

// Şirket silme işlemi için
function deleteCompany(companyId) {
    fetch(`http://localhost:8080/v1/company/delete/${companyId}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (response.ok) {
                console.log(`Company ${companyId} deleted`);
                // İşlem başarılıysa sayfayı yenile veya başka bir işlem yapabilirsiniz
            } else {
                throw new Error('Network response was not ok.');
            }
        })
        .catch(error => {
            console.error('There has been a problem with your fetch operation:', error);
        });
}
