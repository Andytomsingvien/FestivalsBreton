fetch('http://www.7timer.info/bin/api.pl?lon=113.17&lat=23.09&product=astro&output=json').then(response => {
    return response.json()
}).then(data => {
    console.log(data)
}).catch(err => {
    console.error(err)
})

    function ajouterFestival() {
    // Fonction à exécuter lors du clic sur le bouton
    // Rediriger vers la page "nouveau festival"
    window.location.href = "nouveauFestival.html";
}




