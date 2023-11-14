// Import the necessary libraries
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// Define the main activity class
class MainActivity : AppCompatActivity() {

    // Declare the UI elements as variables
    private lateinit var celsiusEditText: EditText // For entering the Celsius value
    private lateinit var fahrenheitTextView: TextView // For displaying the Fahrenheit value
    private lateinit var kelvinTextView: TextView // For displaying the Kelvin value

    // Declare the conversion constants as variables
    private val celsiusToFahrenheitFactor = 1.8f // Factor to convert from Celsius to Fahrenheit
    private val kelvinToCelsiusFactor = 5.0f // Factor to convert from Kelvin to Celsius

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the UI elements with their IDs
        celsiusEditText = findViewById(R.id.celsius_edit_text)
        fahrenheitTextView = findViewById(R.id.fahrenheit_text_view)
        kelvinTextView = findViewById(R.id.kelvin_text_view)

        // Set a click listener for the convert button
        val convertButton = findViewById(R.id.convert_button)
        convertButton.setOnClickListener {
            // Get the input values from the edit texts and parse them as floats
            val celsiusValue = celsiusEditText.text.toString().toFloat()
            val kelvinValue = celsiusEditText.text.toString().toFloat()

            // Check if the input values are valid (not null and positive)
            if (celsiusValue != null && celsiusValue > 0) {
                // Calculate the output values using the conversion factors and display them in the text views
                val fahrenheitValue = celsiusValue * celsiusToFahrenheitFactor
                val kelvinValueCelsius = kelvinValue * kelvinToCelsiusFactor

                fahrenheitTextView.text = "Fahrenheit: $fahrenheitValue"
                kelvinTextView.text = "Kelvin: $kelvinValueCelsius"
            } else {
                // Display an error message if the input values are invalid
                fahrenheitTextView.text = "Invalid input. Please enter a positive number."
                kelvinTextView.text = "Invalid input. Please enter a positive number."
            }
        }
    }
}
