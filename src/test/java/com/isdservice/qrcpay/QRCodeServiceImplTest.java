package com.isdservice.qrcpay;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.WriterException;
import com.isdservice.qrcpay.dto.request.MerchantDetailsRequest;
import com.isdservice.qrcpay.service.serviceImpl.QRCodeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class QRCodeServiceImplTest {

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private QRCodeServiceImpl qrCodeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGenerateQRCode() throws IOException, WriterException {
        // Create a sample MerchantDetailsRequest
        MerchantDetailsRequest merchantDetails = new MerchantDetailsRequest("SampleBank", "1234567890", "SampleMerchant");

        // Call the method under test
        byte[] generatedQRCode = qrCodeService.generateQRCode(merchantDetails);

        // Initialize expectedQRCode with a placeholder byte array.
        byte[] expectedQRCode = new byte[]{};

        // Assert that the generated QR code matches the expected QR code
        assertArrayEquals(expectedQRCode, generatedQRCode);
    }

}
