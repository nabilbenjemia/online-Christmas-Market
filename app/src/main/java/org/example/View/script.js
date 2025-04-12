// Function to hide the menu and show the vendor login form
function registerVendor() {
    // Hide the 'menu' div
    document.getElementById('menu').style.display = 'none';
    // Show the 'vendor-login-form' div
    document.getElementById('vendor-login-form').style.display = 'block';
}

// Function for the visitor registration process (add your visitor handling code here)
function exploreVisitor() {
    document.getElementById('menu').style.display = 'none';
    document.getElementById('visitor-login-form').style.display = 'block';
}

// Function for vendor login (placeholder for now)
async function loginAsVendor() {
    const vendorID = document.getElementById('vendor-id').value;
    const vendorPassword = document.getElementById('vendor-password').value;


    if (vendorID && vendorPassword) {
        try {
            // Send the login details to the backend
            const response = await fetch("http://localhost:8080/market/vendor/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded",
                },
                body: new URLSearchParams({
                    username: vendorID,
                    password: vendorPassword,
                }),
            });

            // Check the response status
            if (response.ok) {
                const message = await response.text();
                alert(`Vendor Login Successful: ${message}`);
                isVendorLoggedIn = true;
                localStorage.setItem("currentVendor", vendorID);
                showVendorDashboard();
                // Redirect to their respective dashboard or homepage (future step)
            } else {
                const errorMessage = await response.text();
                alert(`Vendor Login Failed: ${errorMessage}`);
            }
        } catch (error) {
            console.error("Error during vendor login:", error);
            alert("An error occurred while trying to log in. Please verify the connection to the server");
        }
    } else {
        alert('Please fill in both fields.');
    }
}

async function logoutVendor() {
    vendorID = localStorage.getItem("currentVendor");
    if (vendorID) {
        try {
            // Send the login details to the backend
            const response = await fetch("http://localhost:8080/market/vendor/logout", {
                method: "POST",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded",
                },
                body: new URLSearchParams({
                    username: vendorID,
                }),
            });

            // Check the response status
            if (response.ok) {
                const message = await response.text();
                alert(`Vendor Logged out Successfully: ${message}`);
                isVendorLoggedIn = false;
                localStorage.setItem("currentVendor", vendorID);
                showVendorDashboard();
                // Redirect to their respective dashboard or homepage (future step)
            }
        } catch (error) {
            console.error("Error during vendor login:", error);
            alert("An error occurred while trying to log out. Please verify the connection to the server");
        }
    }
}

async function registerAsVendor() {
    const vendorID = document.getElementById('registervendor-id');
    const vendorPassword = document.getElementById('registervendor-password');
    const vendorDescription = document.getElementById('registervendor-description');

    const id = vendorID.value;
    const password = vendorPassword.value;
    const description = vendorDescription.value;

    if (id && password) {
        try {
            // Send the login details to the backend
            const response = await fetch("http://localhost:8080/market/vendor/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded",
                },
                body: new URLSearchParams({
                    username: id,
                    password: password,
                    description: description,
                }),
            });

            // Check the response status
            if (response.ok) {
                const message = await response.text();
                alert(`Vendor Registration was Successful: ${message}`);
                goBack();
                // Redirect to their respective dashboard or homepage (future step)
            } else {
                const errorMessage = await response.text();
                alert(`Vendor Registration has Failed: ${errorMessage}`);
            }
        } catch (error) {
            console.error("Error during vendor registration:", error);
            alert("An error occurred while trying to log in. Please verify the connection to the server");
        }
    } else {
        alert('Please fill in both fields.');
    }
}

async function registerAsVisitor() {
    const vendorID = document.getElementById('registervisitor-id');
    const vendorPassword = document.getElementById('registervisitor-password');

    const id = vendorID.value;
    const password = vendorPassword.value;

    if (id && password) {
        try {
            // Send the login details to the backend
            const response = await fetch("http://localhost:8080/market/visitor/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded",
                },
                body: new URLSearchParams({
                    username: id,
                    password: password,
                }),
            });

            // Check the response status
            if (response.ok) {
                const message = await response.text();
                alert(`Visitor Registration was Successful: ${message}`);
                goBack();
                exploreVisitor();
                // Redirect to their respective dashboard or homepage (future step)
            } else {
                const errorMessage = await response.text();
                alert(`Visitor Registration has Failed: ${errorMessage}`);
            }
        } catch (error) {
            console.error("Error during visitor registration:", error);
            alert("An error occurred while trying to log in. Please verify the connection to the server");
        }
    } else {
        alert('Please fill in both fields.');
    }
}
let currentVisitor;
async function loginAsVisitor() {
    const visitorID = document.getElementById('visitor-id').value;
    const visitorPassword = document.getElementById('visitor-password').value;


    if (visitorID && visitorPassword) {
        try {
            // Send the login details to the backend
            const response = await fetch("http://localhost:8080/market/visitor/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded",
                },
                body: new URLSearchParams({
                    username: visitorID,
                    password: visitorPassword,
                }),
            });

            // Check the response status
            if (response.ok) {
                const message = await response.text();
                alert(`Visitor Login Successful: ${message}`);
                isVisitorLoggedIn = true;
                localStorage.setItem("currentVisitor", visitorID);
                showVisitorDashboard();
                // Redirect to their respective dashboard or homepage (future step)
            } else {
                const errorMessage = await response.text();
                alert(`Visitor Login Failed: ${errorMessage}`);
            }
        } catch (error) {
            console.error("Error during visitor login:", error);
            alert("An error occurred while trying to log in. Please verify the connection to the server");
        }
    } else {
        alert('Please fill in both fields.');
    }
}

// Placeholder for creating a new vendor
function createVendor() {
    //alert('Vendor creation form will be available soon.');
    // Navigate to vendor registration page when available
    const allElements = document.body.children;
    for (let element of allElements) {
        element.style.display = 'none';
    }
    document.getElementById('vendor-register-form').style.display = 'block';
}

function createVisitor() {
    const allElements = document.body.children;
    for (let element of allElements) {
        element.style.display = 'none';
    }
    document.getElementById('visitor-register-form').style.display = 'block';
}

// Function to go back to the main menu
function goBack() {
    const allElements = document.body.children;
    for (let element of allElements) {
        if (element.id !== 'footer' && element.tagName !== 'FOOTER') {
            element.style.display = 'none';
        }
    }
    if(localStorage.getItem("currentVisitor")) {
        showVisitorDashboard();
        return;
    }
    document.getElementById('menu').style.display = 'block';
    document.getElementById('footer').style.display = 'block';

}

//access vendor dashboard after signing in
function showVendorDashboard() {
    if (isVendorLoggedIn) {
        const allElements = document.body.children;
        for (let element of allElements) {
            element.style.display = 'none';
        }
        document.getElementById("current-vendor-name").textContent = localStorage.getItem('currentVendor');
        document.getElementById("vendor-dashboard").style.display = "block";

    }
}

async function showVisitorDashboard() {
    if (true) { // Assuming some condition to trigger visitor dashboard
        // Hide all other sections
        const allElements = document.body.children;
        for (let element of allElements) {
            element.style.display = 'none';
        }

        // Show the visitor dashboard
        document.getElementById("current-visitor-name").textContent = localStorage.getItem('currentVisitor');
        document.getElementById("visitor-dashboard").style.display = "block";

        // Fetch vendors and their products (if needed)
        try {
            const response = await fetch("http://localhost:8080/market/vendors");
            if (!response.ok) {
                throw new Error(`Error fetching vendors: ${response.status}`);
            }
            const vendors = await response.json();

            // Populate vendors and products into visitor-dashboard
            const vendorsList = document.getElementById("vendors-list");
            vendorsList.innerHTML = ""; // Clear previous content

            vendors.forEach(vendor => {
                const vendorDiv = document.createElement("div");
                vendorDiv.innerHTML = `
                    <h3>${vendor.name}</h3>
                    <ul>
                        ${vendor.products.map(product => `
                            <li>${product.name} - $${product.price} (Available: ${product.amount})</li>
                        `).join('')}
                    </ul>
                `;
                vendorsList.appendChild(vendorDiv);
            });
        } catch (error) {
            console.error("Error loading vendors:", error);
        }
    }
}



document.getElementById("add-product-button").addEventListener("click", function() {
    document.getElementById("add-product-section").style.display = "block";
    document.getElementById("sales-section").style.display = "none";
});

document.getElementById("check-sales-button").addEventListener("click", async function() {
    // Show the sales section and hide the add product section
    document.getElementById("sales-section").style.display = "block";
    document.getElementById("add-product-section").style.display = "none";

    // Get the vendorId (you may get this from the current session or local storage, for example)
    const vendorId = localStorage.getItem("currentVendor");  // Replace this with the actual vendorId
    try {
        // Fetch sales data from the backend using GET request
        const response = await fetch(`http://localhost:8080/market/vendor/${vendorId}/sales`, {
            method: 'GET',  // Explicit GET method (not necessary but can be included for clarity)
        });

        if (response.ok) {
            const salesData = await response.text();  // Assuming the backend returns a string with sales details

            // Update the sales section with the fetched data
            document.getElementById("sales-info").innerHTML = `<pre>${salesData}</pre>`; // Using <pre> to display formatted text
        } else {
            // Handle case when response is not ok
            document.getElementById("sales-info").innerHTML = "Failed to load sales data.";
        }
    } catch (error) {
        console.error("Error fetching sales data:", error);
        document.getElementById("sales-info").innerHTML = "Error loading sales data.";
    }
});


document.getElementById("vendor-logout-button").addEventListener("click", async function () {
    vendorID = localStorage.getItem("currentVendor");
    const response = await fetch("http://localhost:8080/market/vendor/logout", {

        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded",
        },
        body: new URLSearchParams({
            username: vendorID,
        }),
    });
    if (response.ok) {
        const message = await response.text();
        alert(`Vendor Logged out Successfully: ${message}`);
        isVendorLoggedIn = false;
        //localStorage.setItem("currentVendor", "");
        localStorage.clear();
        showVendorDashboard();
        // Redirect to their respective dashboard or homepage (future step)
    }else {
        const errorMessage = await response.text();
        alert(`Vendor Logout Failed: ${errorMessage}`);
    }
    goBack();
});

document.getElementById("visitor-logout-button").addEventListener("click", async function () {
    visitorID = localStorage.getItem("currentVisitor");

    document.getElementById("visitor-dashboard").style.display = "block";
    const response = await fetch("http://localhost:8080/market/visitor/logout", {

        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded",
        },
        body: new URLSearchParams({
            username: visitorID,
        }),
    });
    if (response.ok) {
        const message = await response.text();
        alert(`Visitor Logged out Successfully: ${message}`);
        isVisitorLoggedIn = false;
        //localStorage.setItem("currentVisitor", visitorID);
        localStorage.clear();
        showVisitorDashboard();
        // Redirect to their respective dashboard or homepage (future step)
    }else {
        const errorMessage = await response.text();
        alert(`Vendor Logout Failed: ${errorMessage}`);
    }
    goBack();
});



//add products
function addProducts() {
    const form = document.getElementById("add-product-form");

    // Add the event listener only if it hasn't already been added
    if (!form.dataset.listenerAdded) {
        form.addEventListener("submit", function (event) {
            event.preventDefault();

            // Validate form inputs
            const productName = document.getElementById("product-namee").value;
            const productAmount = document.getElementById("product-amount").value;
            const productPrice = document.getElementById("product-price").value;
            const productDescription = document.getElementById("product-description").value;
            // Check if any field is empty
            if (!productName || !productAmount || !productPrice || !productDescription) {
                alert("Please fill in all fields before submitting.");
                return;
            }

            // Convert productAmount to a number
            const parsedProductAmount = parseInt(productAmount, 10);

            // Ensure parsed amount is valid
            if (isNaN(parsedProductAmount) || parsedProductAmount <= 0) {
                alert("Please enter a valid product amount.");
                return;
            }

            // Retrieve vendor ID
            const currentVendor = localStorage.getItem("currentVendor");
            if (!currentVendor) {
                alert("No vendor selected. Please log in again.");
                return;
            }

            const apiUrl = `/vendor/${currentVendor}/products`;

            // Construct the full URL with query parameters
            const fullUrl = `http://localhost:8080/market${apiUrl}?type=${encodeURIComponent(productName)}&description=${encodeURIComponent(productDescription)}&price=${encodeURIComponent(productPrice)}&amount=${encodeURIComponent(productAmount)}`;

            // Make the POST request
            fetch(fullUrl, {
                method: "POST",
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error("Failed to add product: " + response.status);
                    }
                    return response.text(); // Assuming your backend responds with a plain text message
                })
                .then(data => {
                    alert(data); // Show the response message from the backend
                    form.reset(); // Reset form after successful submission
                })
                .catch(error => {
                    console.error("Error:", error);
                    alert("Error adding product. Please try again. " + error);
                });
        });

        // Mark that the listener has been added to prevent duplicates
        form.dataset.listenerAdded = true;
    }
}



//products viewer
let currentIndex = 0;

function updateView() {
    const offset = -currentIndex * 300; // Adjust position
    document.getElementById('product-container').style.transform = `translateX(${offset}px)`;

    // Get the current product name from the data-name attribute
    const currentProduct = document.querySelector(`.product[data-index="${currentIndex}"]`);
    const productName = currentProduct.getAttribute('data-name');

    // Update the product name in the viewer
    document.getElementById('product-name').textContent = productName;
}

document.getElementById('prev').addEventListener('click', () => {
    if (currentIndex > 0) {
        currentIndex--;
        updateView();
    }
});

document.getElementById('next').addEventListener('click', () => {
    if (currentIndex < document.querySelectorAll('.product').length - 1) {
        currentIndex++;
        updateView();
    }
});


//display vendor list
const dummyVendorList = [
    { name: "Vendor 1", description: "Handmade Christmas Ornaments" },
    { name: "Vendor 2", description: "Gourmet Christmas Cookies" },
    { name: "Vendor 3", description: "Christmas Sweaters and Apparel" },
    { name: "Vendor 4", description: "Hot Chocolate and Mulled Wine" }
];

async function showVendorList() {
    const vendorListDiv = document.getElementById("vendor-list");
    const vendorListContainer = document.getElementById("vendor-list-container");

    vendorListContainer.innerHTML = "";

    try {
        // Fetch the vendor list from the backend
        const response = await fetch("http://localhost:8080/market/vendor/all", {
            headers: { "Content-Type": "application/json" },
        });

        if (!response.ok) {
            throw new Error("Failed to fetch vendor list");
        } else {
            console.log("Response received:", response.status);
        }

        // Parse the JSON response
        const vendorList = await response.json();

        // Update the vendor list container with the fetched data

        vendorList.forEach((vendor) => {
            const listItem = document.createElement("li");
            listItem.className = "vendor-item";
            listItem.innerHTML = `<strong>${vendor.username}</strong>: ${
                vendor.loggedIn ? "Online" : "Offline"
            }`;
            vendorListContainer.append(listItem);
        });


    } catch (error) {
        console.error("Error retrieving vendor list:", error);
        vendorListContainer.innerHTML = "<li>Error fetching vendor list</li>";
    }

    // Show the vendor list and hide the menu
    document.getElementById("menu").style.display = "none";
    vendorListDiv.style.display = "block";
}



async function showVendorCarousel() {
    const allElements = document.body.children;
    for (let element of allElements) {
        element.style.display = 'none';
    }
    document.getElementById('vendor-carousel-container').style.display = 'block';

    const vendorCarousel = document.querySelector('.vendor-carousel');
    vendorCarousel.innerHTML = ""; // Clear previous content

    try {
        const response = await fetch("http://localhost:8080/market/vendor/all", {
            headers: { "Content-Type": "application/json" },
        });

        if (!response.ok) {
            throw new Error("Failed to fetch vendor list");
        }

        const vendorList = await response.json();

        vendorList.forEach((vendor) => {
            const vendorBox = document.createElement("div");
            vendorBox.className = "vendor-box";
            vendorBox.innerHTML = `
                <h3 class="vendor-title">${vendor.username}</h3>
                <p class="vendor-status">${vendor.description}</p>
            `;

            // Make the vendorBox clickable
            vendorBox.addEventListener("click", async () => {
                try {
                    const productResponse = await fetch(`http://localhost:8080/market/vendor/${vendor.username}/products`, {
                        headers: { "Content-Type": "application/json" },
                    });

                    if (!productResponse.ok) {
                        throw new Error(`Failed to fetch products for vendor: ${vendor.username}`);
                    }

                    const products = await productResponse.json();
                    displayProducts(products, vendor.username);
                } catch (error) {
                    console.error("Error fetching vendor products:", error);
                    alert("error: "+ error);
                }
            });

            vendorCarousel.append(vendorBox);
        });

        /////////////


        ///////////

        let currentIndex = 0;
        const vendors = document.querySelectorAll('.vendor-box');
        const totalVendors = vendors.length;

        if (totalVendors === 1) {
            vendorCarousel.style.position = 'relative';
            vendorCarousel.style.left = '38%';
        } else if (totalVendors === 2) {
            vendorCarousel.style.position = 'relative';
            vendorCarousel.style.left = '27%';
        } else if (totalVendors === 3) {
            vendorCarousel.style.position = 'relative';
            vendorCarousel.style.left = '15%';
        } else {
            vendorCarousel.style.position = 'relative';
            vendorCarousel.style.right = '7%';
        }

        function updateCarousel() {
            const offset = -(currentIndex * 312); // Move by 305px for each box
            vendorCarousel.style.transform = `translateX(${offset}px)`;
        }

        document.getElementById('prev').addEventListener('click', () => {
            if (currentIndex > 0) {
                currentIndex--;
                updateCarousel();
            }
        });

        document.getElementById('next').addEventListener('click', () => {
            if (currentIndex < totalVendors - 1) {
                currentIndex++;
                updateCarousel();
            }
        });

        vendorCarousel.style.width = `${totalVendors * (vendors[0].offsetWidth + 30)}px`;
        updateCarousel();
    } catch (error) {
        console.error("Error retrieving vendor list:", error);
        vendorCarousel.innerHTML = "<p>Error fetching vendor data</p>";
    }
}

async function showCart() {
    let visitorID = localStorage.getItem("currentVisitor");

    const cartContainer = document.getElementById("cartContainer");
    const dashboardButtons = document.querySelector(".dashboard-buttons");

    // Hide other elements and show the cart
    dashboardButtons.style.display = "none"; // Hide buttons
    cartContainer.style.display = "block"; // Show cart container

    try {
        const response = await fetch(`http://localhost:8080/market/visitor/${visitorID}/cart`);
        if (!response.ok) {
            throw new Error(`Error fetching cart: ${response.statusText}`);
        }

        const cartData = await response.json();
        displayCart(cartData);
    } catch (error) {
        console.error("Failed to load cart:", error);
        cartContainer.innerHTML = "<p>Failed to load cart. Please try again.</p>";
    }
}

function displayCart(cartData) {
    const cartContainer = document.getElementById("cartContainer");
    cartContainer.innerHTML = ''; // Clear previous content

    if (!cartData.items || cartData.items.length === 0) {
        cartContainer.innerHTML = '<p>Your cart is empty.</p>';
        return;
    }

    const ul = document.createElement('ul');
    cartData.items.forEach(item => {
        const li = document.createElement('li');
        li.textContent = `
            Type: ${item.type}, 
            Price: $${item.price}, 
            Description: ${item.description}, 
            State: ${item.state.type}
        `;
        ul.appendChild(li);
    });
    cartContainer.appendChild(ul);
    const purchaseButton = document.createElement('button');
    purchaseButton.textContent = "Purchase";
    purchaseButton.classList.add('button');
    purchaseButton.onclick = () => {
        purchaseCart();
    };
    cartContainer.appendChild(purchaseButton);
}

async function purchaseCart() {
    let visitorID = localStorage.getItem("currentVisitor");
    alert("Visitor ID: " + visitorID); // Check if the ID is valid

    if (!visitorID) {
        alert("No visitor ID found in localStorage.");
        return;
    }

    try {
        const response = await fetch(`http://localhost:8080/market/visitor/${visitorID}/purchase`,
            {method: 'POST'
    })

        if (!response.ok) {
            throw new Error(`Error purchasing: ${response.statusText}`);
        }

        const responseText = await response.text();
        alert("Response: " + responseText); // Show the response
        await showCart();
    } catch (error) {
        console.error("Failed to load cart:", error);
        alert("Error: " + error.message); // More specific error message
    }
}


async function displayProducts(productsByType, vendorName) {
    // Hide all elements initially
    const allElements = document.body.children;
    for (let element of allElements) {
        element.style.display = 'none';
    }

    const productCarouselContainer = document.getElementById('product-carousel-container');
    const productCarousel = document.querySelector('.product-carousel');
    productCarousel.innerHTML = ""; // Clear any existing content
    productCarouselContainer.style.display = 'block';

    const vendorNameSpan = document.getElementById('vendor-name');
    vendorNameSpan.textContent = vendorName;

    // Populate the carousel with product data
    Object.entries(productsByType).forEach(([productString, count]) => {
        // Regular expression to extract type, description, and price from the productString
        const normalizedString = productString.replace(/\r?\n/g, "\\n");

        const regex = /Product\{type=(.*?), description='(.*?)', price=(.*?)\}/;
        const match = normalizedString.match(regex);

        if (match) {
            const type = match[1];
            const description = match[2].replace(/\\n/g, "<br>");
            const price = match[3];

            const productBox = document.createElement("div");
            productBox.className = "product-box";
            productBox.innerHTML = `
            <h2>${type}</h2>
            <h4>Description: ${description}</h4>
            <!--p>Hurry up we only have: ${count} Products</p-->
            <p>Price: ${price}€ ONLY!</p>
            <input type="number" id="select-quantity" min="1" max="${count}" value="1">
            <button class="add-to-cart" data-product="${type}" data-price="${price}">Add to Cart</button>

        `;
            const addToCartButton = productBox.querySelector('.add-to-cart');

            addToCartButton.addEventListener("click", async () => {
                // alert(`You selected: ${type}`);
                const currentVisitor = localStorage.getItem("currentVisitor");
                if (!currentVisitor) {
                    alert("Please log in to be able to buy this product");
                    goBack();
                    return;
                }
 /////////////////////////////////////
                const quantity = parseInt(productBox.querySelector("#select-quantity").value, 10);
                const productType = productBox.querySelector('.add-to-cart').getAttribute("data-product");

                // Assuming vendorId is available as a variable or is part of the page context
                //const vendorId = document.getElementById('vendor-name').value;  // Or fetch it from your application context

                // Construct the URL to call
                const BASE_URL = 'http://localhost:8080/market';  // Replace with your backend base URL
                const addToCartUrl = `${BASE_URL}/cart/${currentVisitor}/${vendorName}?type=${productType}&amount=${quantity}`;
                // Make the API call to add product to the cart
                fetch(addToCartUrl, {
                    method: 'POST',
                })
                    .then(response => response.text())  // Use `.text()` instead of `.json()`
                    .then(async data => {
                        alert(data);  // Assuming the response is a message string from the server


                        const updatedProducts = await fetch(`http://localhost:8080/market/vendor/${vendorName}/products`)
                            .then(res => res.json()); // Assuming the endpoint returns updated products in JSON format

                        // Now, re-render the products with updated availability
                        await displayProducts(updatedProducts, vendorName);

                    })
                    .catch(error => {
                        console.error('Error:', error);
                        alert("No products available at the moment.");
                    });

///////////////////////////////////////////////////////////////////

            });
            productCarousel.appendChild(productBox);
        } else {
            console.error("Product string does not match expected format:", productString);
            alert("Product string does not match expected format:\ " + productString);
        }
    });

    // css (if there's only 1/2 boxes)
    const productBoxes = productCarousel.querySelectorAll('.product-box');
    if (productBoxes.length === 1) {
        productCarousel.style.position = 'relative';
        productCarousel.style.left = '35%';
    } else if (productBoxes.length === 2) {
        productCarousel.style.position = 'relative';
        productCarousel.style.left = '18%';
    } else {
        productCarousel.style.position = ''; // Reset
        productCarousel.style.left = '';    // Reset
    }


    // Initialize carousel navigation
    let currentIndex = 0;
    const products = document.querySelectorAll('.product-box');
    const totalProducts = products.length;

    function updateCarousel() {
        const offset = -(currentIndex * (products[0].offsetWidth + 30)); // Adjust for margins
        productCarousel.style.transform = `translateX(${offset}px)`; // Slide the carousel
    }

    // Navigation buttons
    document.getElementById('prev-product').addEventListener('click', () => {
        if (currentIndex > 0) {
            currentIndex--;
            updateCarousel();
        }
    });

    document.getElementById('next-product').addEventListener('click', () => {
        if (currentIndex < totalProducts - 1) {
            currentIndex++;
            updateCarousel();
        }
    });

    /*document.getElementById('back').addEventListener('click', () => {
        if (currentIndex < totalProducts - 1) {
            currentIndex++;
            updateCarousel();
        }
    });*/

    // Ensure carousel has correct width
    productCarousel.style.width = `${totalProducts * (products[0].offsetWidth + 30)}px`;

    // Initial update
    updateCarousel();
}





//get all vendors
async function getAllVendors() {
    try {
        const response = await fetch('http://localhost:8080/market/vendor/all');
        const vendors = await response.json();
        console.log(vendors);
    } catch (error) {
        console.error('Error fetching vendors:', error);
    }
}

//get all visitors
async function getAllVisitors() {
    try {
        const response = await fetch('http://localhost:8080/market/visitor/all');
        const visitors = await response.json();
        console.log(visitors);
    } catch (error) {
        console.error('Error fetching visitors:', error);
    }
}

function RandomInRange(min, max) {
    return Math.random() * (max - min) + min;
}

document.addEventListener('DOMContentLoaded', function() {
    let snowContainer = document.querySelector('.initial-snow');

    // Create 50 snowflakes
    for (let i = 0; i < 50; i++) {
        let snowflake = document.createElement('div');
        snowflake.classList.add('snow');

        // Randomize the starting horizontal position (left)
        let randomXStart = RandomInRange(0, 145); // Random start position in percentage (0-100)

        // Randomize vertical starting position (top)
        let randomY = Math.random() * 100; // Random vertical starting position in percentage
        snowflake.style.left = `${randomXStart}vw`; // Set random X position (start)
        snowflake.style.top = `${randomY}vh`;      // Set random Y position (start)

        // Randomize animation duration and delay for each snowflake
        let randomDuration = RandomInRange(20, 30); // Random duration between 15-30 seconds
        snowflake.style.animationDuration = `${randomDuration}s`;

        // Ensure the snowflake is always moving, remove it if stuck
        snowflake.style.animationIterationCount = "infinite"; // Ensure the animation repeats infinitely

        // Create the snowflake symbol
        snowflake.innerHTML = '&#10052;';

        // Append snowflake to container
        snowContainer.appendChild(snowflake);
    }

    // Ensure all snowflakes are visible and moving
    setInterval(() => {
        const snowflakes = document.querySelectorAll('.snow');

        snowflakes.forEach(snowflake => {
            // Check if snowflake is stuck at top or not moving
            const topPosition = parseFloat(snowflake.style.top);
            if (topPosition < 0 || topPosition > 100) {
                // Reset the snowflake's position to keep it within the screen bounds
                snowflake.style.top = '0vh';
                snowflake.style.left = `${RandomInRange(0, 140)}vw`; // Random horizontal position
            }
        });
    }, 100); // Check every 100ms
});



// Initialize view
updateView();



