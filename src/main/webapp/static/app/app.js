function initRegistraionForm() {
    $(document).on("submit", "#registraionForm", function (e) {
        console.log("Registraion form submitted");
        if($("#email").val() === '') {
            return false;
        }
    });
}