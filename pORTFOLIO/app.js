window.addEventListener('DOMContentLoaded', (event) => {
    document.querySelectorAll('.progress').forEach((item) => {
        let value = item.getAttribute('data-value');
        let bar = item.querySelector('.progress-bar');
        setTimeout(function() {
            bar.style.width = value;
        }, 500); /* ritardo dell'animazione */
    });
});