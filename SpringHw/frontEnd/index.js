const inputForm = document.querySelector(".inputForm");
const nameInput = document.getElementById("subscName");
const surnameInput = document.getElementById("subscSurname");
const msisdnInput = document.getElementById("msisdn");
const tariffIdInput = document.getElementById("tariffId");
const startDateInput = document.getElementById("startDate");

async function addToServer(e) {
  e.preventDefault();
  console.log("selam abi");
  const subscriberJson = {
    TARIFF_ID: parseInt(tariffIdInput.value),
    SUBSC_NAME: nameInput.value,
    START_DATE: startDateInput.value,
    MSISDN: msisdnInput.value,
    SUBSC_SURNAME: surnameInput.value,
  };

  try {
    console.log("selam abi 2");
    const response = await fetch("http://localhost:8080/api/subscribers/add", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Content-Length": 0,
        Origin: "http://127.0.0.1:5501",
        Date: "Sun, 30 Jul 2023 12:23:09 GMT",
        "Keep-Alive": "timeout=60",
        Connection: "keep-alive",
      },
      body: JSON.stringify(subscriberJson),
    });

    if (response.ok) {
      console.log("Kayıt başarılı!");
      alert("Kayıt başarılı!");
      nameInput.value = "";
      surnameInput.value = "";
      msisdnInput.value = "";
      tariffIdInput.value = "";
      startDateInput.value = "";

      form.reset();
    } else {
      alert("Kayıt başarısız!");
      console.error("Kayıt başarısız!");
    }
  } catch (error) {
    console.error("Bir hata oluştu:", error);
  }
}

function eventListeners() {
  inputForm.addEventListener("submit", addToServer);
}
eventListeners();
