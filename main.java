
// ================================
// MOBILE NAVIGATION
// ================================

const menuBtn = document.getElementById("menuBtn");
const navLinks = document.getElementById("navLinks");

menuBtn.addEventListener("click", function () {
    navLinks.classList.toggle("active");
});


// Close mobile menu when a link is clicked

const links = document.querySelectorAll(".nav-links a");

links.forEach(function (link) {

    link.addEventListener("click", function () {
        navLinks.classList.remove("active");
    });

});


// ================================
// ACTIVE NAVIGATION LINK
// ================================

const sections = document.querySelectorAll("section");
const navItems = document.querySelectorAll(".nav-links a");

window.addEventListener("scroll", function () {

    let currentSection = "";

    sections.forEach(function (section) {

        const sectionTop = section.offsetTop - 120;
        const sectionHeight = section.clientHeight;

        if (window.scrollY >= sectionTop &&
            window.scrollY < sectionTop + sectionHeight) {

            currentSection = section.getAttribute("id");

        }

    });

    navItems.forEach(function (item) {

        item.classList.remove("active");

        if (item.getAttribute("href") === "#" + currentSection) {
            item.classList.add("active");
        }

    });

});


// ================================
// SCROLL REVEAL ANIMATION
// ================================

const animatedElements = document.querySelectorAll(
    ".skill-card, .project-card, .info-card, .education-card, .contact-card"
);

const observer = new IntersectionObserver(

    function (entries) {

        entries.forEach(function (entry) {

            if (entry.isIntersecting) {

                entry.target.style.opacity = "1";
                entry.target.style.transform = "translateY(0)";

            }

        });

    },

    {
        threshold: 0.15
    }

);


animatedElements.forEach(function (element) {

    element.style.opacity = "0";
    element.style.transform = "translateY(25px)";
    element.style.transition = "opacity 0.6s ease, transform 0.6s ease";

    observer.observe(element);

});


// ================================
// CURRENT YEAR
// ================================

const year = new Date().getFullYear();

const footer = document.querySelector("footer p");

if (footer) {
    footer.innerHTML =
        `© ${year} ANUSIYA M. All Rights Reserved.`;
}
