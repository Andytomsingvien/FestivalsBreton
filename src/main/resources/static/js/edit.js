function confirmerSuppression(id) {
    if (confirm("Êtes-vous sûr de vouloir supprimer ce festival ?")) {
        window.location.href = "/delete/" + id;
    }
}

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


// La map Leaflet
let mymap = L.map('map').setView([48.202047, -2.932644], 8);
// Ajout d'un layer sur la map pour afficher des tuiles avec les routes
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    tileSize: 512,
    zoomOffset: -1,
    maxZoom: 18
}).addTo(mymap);

/**
 * Ajoute un marqueur sur la carte.
 *
 * @param {number} lat Latitude du marqueur.
 * @param {number} lon Longitude du marqueur.
 * @param {string} festivalName Le nom du festival à afficher dans la popup.
 * @param {string} festivalVille La ville du festival à afficher dans la popup.
 */
function addMarkerOnMap(lat, lon, festivalName, festivalVille) {
    // On ajoute une marque aux coordonnées fournies en paramètre
    marker = L.marker([lat, lon]).addTo(mymap);
    // Un popup qui s'affichera au-dessus du marqueur
    let popup = L.popup().setContent(`<h2>${festivalName}</h2><h3>${festivalVille}</h3>`);
    marker.bindPopup(popup);
    marker.addEventListener('click', (event) => {
        popup.openOn(mymap);
    });
}

