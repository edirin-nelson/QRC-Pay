# QRC-PAY App

QRC-PAY is a mobile application that allows users to make payments by scanning QR codes. The app provides a seamless and convenient way for users to make transactions without the need for physical cash or credit cards.

## Features

- **QR Code Scanner:** Users can use the built-in QR code scanner to scan QR codes from merchants and make payments.

- **Merchant Registration:** Merchants can register on the app and generate unique QR codes for their businesses to accept payments.

- **User Registration:** Users can sign up on the app to access all the payment features.

- **Secure Payments:** The app ensures secure and encrypted transactions, protecting users' financial data.

- **Onboarding Screens:** The app includes user-friendly onboarding screens for a smooth introduction to its functionality.

- **Responsive Design:** The user interface is designed to be responsive and work smoothly on both Android and iOS devices.

## Technology Stack

The QRC-PAY app is built using the following technologies:

- **Frontend:**
    - React Native: A popular JavaScript framework for building cross-platform mobile apps.
    - Expo: A toolset for building, deploying, and testing React Native applications.
    - React Navigation: A library for handling navigation in the app.
    - Axios: A promise-based HTTP client for making API requests.

- **Backend:**
    - Spring Boot: A powerful Java-based framework for building backend applications.
    - Spring Security: Provides authentication and security features for the API.
    - Postgres: A relational database to store user and merchant data.
    - QR Code Generation: Zxing library for generating QR codes.

## Installation

To run the QRC-PAY app locally, follow these steps:

### Frontend Setup

1. Clone the repository from GitHub.

```bash
git clone https://github.com/edirin-nelson/QRC-Pay
```

2. Navigate to the `qrc-pay` directory.

```bash
cd qrc-pay
```

3. Install the dependencies using npm or yarn.

```bash
npm install
```
or
```bash
yarn install
```

4. Start the development server.

```bash
npm start
```
or
```bash
yarn start
```

5. The app will be accessible in your browser at `http://localhost:19002`.

### Backend Setup

1. Clone the backend repository from GitHub.

```bash
git clone https://github.com/edirin-nelson/payment-with-QRcode
```

2. Navigate to the `qrc-pay-backend` directory.

```bash
cd qrc-pay-backend
```

3. Install the required dependencies.

```bash
mvn install
```

4. Start the Spring Boot application.

```bash
mvn spring-boot:run
```

5. The backend server will be accessible at `http://localhost:9000`.

## Usage

- Open the QRC-PAY app on your mobile device/emulator.

- Use the QR code scanner to scan QR codes from merchants.

- Complete the payment process by entering the required information (amount, PIN, etc.).

- Merchants can register on the app to generate their unique QR codes for payments.

- Users can register on the app to access all payment features.

## Contributing

Contributions to QRC-PAY are welcome! If you find any bugs or have suggestions for improvements, please create an issue on the GitHub repository.

## License

The QRC-PAY app is open-source and available under the [MIT License](https://opensource.org/licenses/MIT).

## Acknowledgments

Special thanks to the developers who contributed to the libraries and tools used in this project.

Happy payments with QRC-PAY! 🚀