function confirmerSuppression(id) {
    if (confirm("Êtes-vous sûr de vouloir supprimer ce festival ?")) {
        window.location.href = "/delete/" + id;
    }
}