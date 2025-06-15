document.addEventListener('DOMContentLoaded', function () {
    const toggler = document.querySelector('.navbar-toggler');
    if (!toggler) return;

    const hamburger = toggler.querySelector('.icon-hamburger');
    const closeIcon = toggler.querySelector('.icon-close');
    const navbarCollapse = document.getElementById('navbarNav');

    if (!hamburger || !closeIcon || !navbarCollapse) return;

    navbarCollapse.addEventListener('show.bs.collapse', () => {
        hamburger.classList.add('d-none');
        closeIcon.classList.remove('d-none');
    });

    navbarCollapse.addEventListener('hide.bs.collapse', () => {
        closeIcon.classList.add('d-none');
        hamburger.classList.remove('d-none');
    });
});