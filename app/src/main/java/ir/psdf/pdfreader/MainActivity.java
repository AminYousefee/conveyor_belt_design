package ir.psdf.pdfreader;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    EditText material_edit;
    EditText angle_of_surcharge;
    EditText angle_of_repose;
    EditText lump_size;
    EditText specific_weight;
    EditText abrasiveness;
    EditText corrosiveness;
    EditText physical_characteristics;
    EditText v_max_from_table;
    EditText v_max_desired;
    EditText load_capacity_of_the_belt;
    EditText load_capacity_of_the_belt_stph;
    EditText lambda;
    EditText design_of_the_troughing_sets;
    EditText loaded_volume2;
    EditText inclination;
    EditText factor_of_inclination;
    EditText feed1;
    EditText feed2;
    EditText feed3;
    EditText feed4;
    EditText editTextNumberDecimal;
    EditText belt_width;
    public static final String[] pdfFileNames = {
            "tab-1.pdf",
            "tab-2.pdf",
            "tab-3.pdf",
            "tab-4.pdf",
            "tab-5.pdf",
            "tab-7.pdf",
            "tab-8.pdf",
            "tab-9.pdf",
            "tab-10.pdf",
            "tab-11.pdf",
            "tab-16.pdf",
            "tab-17.pdf",
            "tab-18.pdf",
            "tab-19.pdf",
            "tab-20.pdf",
            "tab-21.pdf",
            "fig-8.pdf",
            "physical_properties.pdf",
            "roler_set.pdf"
    };
    EditText belt_width2;
    EditText impact_factor;
    EditText utilisation;
    EditText service_factor;
    EditText environment_factor;
    EditText participation_factor_in_upper;
    EditText speed_factor;
    EditText return_troughing_set_with_a_transom_side_roller_angle;
    EditText participation_factor_in_return;
    EditText diameter_of_rollers;
    EditText belt_kind;
    EditText textile_core_EP;
    EditText steel_core_ST;
    EditText Belt_core_weight;
    EditText thickness_of_belt;
    EditText working_condition;
    EditText Coefficient_of_internal_friction;
    EditText Coefficient_of_fixed_resistance;
    EditText temperature;
    EditText Coefficient_of_passive_resistance;
    EditText Maximum_advised_pitch_of_troughing_sets;
    EditText weight_of_upper_rotating;
    EditText weight_of_lower_rotating;
    EditText Height_change_of_belt;
    EditText center_to_center;
    EditText efficiency_of_the_reduction;


    TextView load_capacity_of_the_belt_final;
    TextView loaded_volume;
    TextView roll_troughing_sets;
    TextView loaded_volume1;
    TextView correction_factor;
    TextView modified_loaded_volume1;
    TextView modified_loaded_volume2;
    TextView static_load;
    TextView dynamic_load;
    TextView load_on_the_roller_carrying_the_most_force;
    TextView static_load_on_the_return_roller_set;
    TextView dynamic_load_on_the_return_roller_set;
    TextView load_on_the_rollers_of_the_return_roller_set;
    TextView Belt_weight_per_linear_metre;
    TextView Weight_of_upper_rotating_parts;
    TextView Weight_of_lower_rotating_parts;
    TextView Weight_material_per_linear_metre;
    TextView rise_or_fall;
    TextView tangential_force_of_the_belt_upper_strand;
    TextView tangential_force_of_the_belt_lower_strand;
    TextView Tangential_force;
    TextView Driving_power;


    Button tab1;
    Button tab2;
    Button physical_characteristics_button;
    Button tab3;
    Button roller_button;
    Button fig8;
    Button tab4;
    Button tab5;
    Button tab20;
    Button tab19;
    Button tab17;
    Button tab21;
    Button tab16;
    Button tab10;
    Button tab9;
    Button tab7;
    Button tab8;
    Button tab11;
    Button tab18;
    EditText min_belt_width;

    public static boolean checkDouble(String numericString) {
        if (numericString == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(numericString);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void update_Driving_power() {
        int inputNumber = 3;
        View[] views = {Tangential_force,
                v_max_from_table,
                efficiency_of_the_reduction
        };
        String[] defaults = {"2376.944091", "2.3", "0.86"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            doubleAns = (doubleValues[0] * doubleValues[1]) / (100 * doubleValues[2]);
            stringAns = String.valueOf(doubleAns);
            Driving_power.setText(stringAns);
        }
    }

    public void update_Tangential_force() {
        int inputNumber = 2;
        View[] views = {tangential_force_of_the_belt_upper_strand,
                tangential_force_of_the_belt_lower_strand
        };
        String[] defaults = {"2468.8392", "-91.8951"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            doubleAns = doubleValues[0] / doubleValues[1];
            stringAns = String.valueOf(doubleAns);
            Tangential_force.setText(stringAns);
        }
    }

    public void update_tangential_force_of_the_belt_lower_strand() { //F200 = 1.5 is not assigned in phase 1
        int inputNumber = 8;
        View[] views = {Height_change_of_belt, //F88 value 0
                center_to_center, //F90 value 1
                Coefficient_of_fixed_resistance, //F79 value 2
                Coefficient_of_passive_resistance, //F81 value 3
                Coefficient_of_internal_friction, //F77 value 4
                Belt_weight_per_linear_metre, //F74 value 5
                Weight_of_lower_rotating_parts, //F83 value 6
                Weight_of_upper_rotating_parts, //F82 value 7

        };
        String[] defaults = {"15", "150", "1.5", "1", "0.017", "9.9", "4.333333", "14.83333"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            if (doubleValues[0] > 0) {
                doubleAns = (doubleValues[1] * doubleValues[2] * doubleValues[3] * doubleValues[4] * (doubleValues[5] + doubleValues[6]) - (doubleValues[5] * doubleValues[0])) * 0.981;
            } else {
                doubleAns = (1.5 * doubleValues[2] * doubleValues[3] * doubleValues[4] * (doubleValues[5] + doubleValues[6]) + (doubleValues[5] * doubleValues[0])) * 0.981;
            }
            stringAns = String.valueOf(doubleAns);
            tangential_force_of_the_belt_lower_strand.setText(stringAns);
        }
    }


    public void update_tangential_force_of_the_belt_upper_strand() { //F200 = 1.5 is not assigned in phase 1
        int inputNumber = 8;
        View[] views = {Height_change_of_belt, //F88 value 0
                center_to_center, //F90 value 1
                Coefficient_of_fixed_resistance, //F79 value 2
                Coefficient_of_passive_resistance, //F81 value 3
                Coefficient_of_internal_friction, //F77 value 4
                Belt_weight_per_linear_metre, //F74 value 5
                Weight_material_per_linear_metre, //F84 value 6
                Weight_of_upper_rotating_parts, //F82 value 7

        };
        String[] defaults = {"15", "150", "1.5", "1", "0.017", "9.9", "120.77294", "14.83333"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            if (doubleValues[0] > 0) {
                doubleAns = (doubleValues[1] * doubleValues[2] * doubleValues[3] * doubleValues[4] * (doubleValues[5] + doubleValues[6] + doubleValues[7]) + doubleValues[0] * (doubleValues[6] + doubleValues[5])) * 0.981;
            } else {
                doubleAns = (1.5 * doubleValues[2] * doubleValues[3] * doubleValues[4] * (doubleValues[5] + doubleValues[6] + doubleValues[7]) - doubleValues[0] * (doubleValues[6] + doubleValues[5])) * 0.981;
            }
            stringAns = String.valueOf(doubleAns);
            tangential_force_of_the_belt_upper_strand.setText(stringAns);
        }
    }

    public void update_rise_or_fall() {
        int inputNumber = 1;
        View[] views = {Height_change_of_belt
        };
        String[] defaults = {"15"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            if (doubleValues[0] > 0) {
                stringAns = "+";
            } else {
                stringAns = "-";
            }
            rise_or_fall.setText(stringAns);
        }
    }

    public void update_Weight_material_per_linear_metre() {
        int inputNumber = 2;
        View[] views = {load_capacity_of_the_belt,
                v_max_from_table
        };
        String[] defaults = {"1000", "2.3"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            doubleAns = doubleValues[0] / 3.0;
            stringAns = String.valueOf(doubleAns);
            Weight_material_per_linear_metre.setText(stringAns);
        }
    }

    public void update_Weight_of_lower_rotating_parts() { //F199 was not assigned in phase 1
        int inputNumber = 1;
        View[] views = {weight_of_lower_rotating

        };
        String[] defaults = {"13.3"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            doubleAns = doubleValues[0] / 3.0;
            stringAns = String.valueOf(doubleAns);
            Weight_of_lower_rotating_parts.setText(stringAns);
        }
    }

    public void update_Weight_of_upper_rotating_parts() { //F198 was not assigned in phase 1
        int inputNumber = 1;
        View[] views = {weight_of_upper_rotating

        };
        String[] defaults = {"17.8"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            doubleAns = doubleValues[0] / 1.2;
            stringAns = String.valueOf(doubleAns);
            Weight_of_upper_rotating_parts.setText(stringAns);
        }
    }

    public void update_Belt_weight_per_linear_metre() {
        int inputNumber = 2;
        View[] views = {Belt_core_weight,
                thickness_of_belt,
        };
        String[] defaults = {"3", "6"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            doubleAns = doubleValues[0] + doubleValues[1] * 1.15;
            stringAns = String.valueOf(doubleAns);
            Belt_weight_per_linear_metre.setText(stringAns);
        }
    }

    public void update_load_on_the_rollers_of_the_return_roller_set() {
        int inputNumber = 2;
        View[] views = {dynamic_load_on_the_return_roller_set,
                participation_factor_in_return,
        };
        String[] defaults = {"31.087792", "1"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            doubleAns = doubleValues[0] * doubleValues[1];
            stringAns = String.valueOf(doubleAns);
            load_on_the_rollers_of_the_return_roller_set.setText(stringAns);
        }
    }

    public void update_dynamic_load_on_the_return_roller_set() { // F199 was not assigned here on phase 1
        int inputNumber = 4;
        View[] views = {static_load_on_the_return_roller_set,
                service_factor,
                environment_factor,
                speed_factor
        };
        String[] defaults = {"29.1357", "1.1", "1", "0.97"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            doubleAns = doubleValues[0] * doubleValues[1] * doubleValues[2] * doubleValues[3];
            stringAns = String.valueOf(doubleAns);
            dynamic_load_on_the_return_roller_set.setText(stringAns);
        }
    }

    public void update_static_load_on_the_return_roller_set() { // F199 was not assigned here on phase 1
        int inputNumber = 1;
        View[] views = {Belt_weight_per_linear_metre
        };
        String[] defaults = {"9.9"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            doubleAns = 3 * doubleValues[0] * 0.981;
            stringAns = String.valueOf(doubleAns);
            static_load_on_the_return_roller_set.setText(stringAns);
        }
    }

    public void update_load_on_the_roller_carrying_the_most_force() {
        int inputNumber = 2;
        View[] views = {dynamic_load,
                participation_factor_in_upper
        };
        String[] defaults = {"174.2873", "0.65"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            doubleAns = doubleValues[0] * doubleValues[1];
            stringAns = String.valueOf(doubleAns);
            load_on_the_roller_carrying_the_most_force.setText(stringAns);
        }
    }

    public void update_dynamic_load() {
        int inputNumber = 4;
        View[] views = {static_load,
                impact_factor,
                service_factor,
                environment_factor
        };
        String[] defaults = {"153.8281", "1.03", "1.1", "1"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            doubleAns = doubleValues[0] * doubleValues[1] * doubleValues[2] * doubleValues[3];
            stringAns = String.valueOf(doubleAns);
            dynamic_load.setText(stringAns);
        }
    }

    public void update_static_load() {  //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ F198 = 1.2 was not assigned in project phase1
        int inputNumber = 3;
        View[] views = {Belt_weight_per_linear_metre,
                load_capacity_of_the_belt_final,
                v_max_from_table
        };
        String[] defaults = {"9.9", "1000", "2.3"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            doubleAns = 1.2 * (doubleValues[0] + (doubleValues[1] / (3.6 * doubleValues[2]))) * 0.981;
            stringAns = String.valueOf(doubleAns);
            static_load.setText(stringAns);
        }
    }

    public void update_modified_loaded_volume2() {
        int inputNumber = 3;
        View[] views = {loaded_volume1,
                correction_factor,
                factor_of_inclination
        };
        String[] defaults = {"2000", "0.9", "0.98"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            doubleAns = doubleValues[0] * doubleValues[1] * doubleValues[2];
            stringAns = String.valueOf(doubleAns);
            modified_loaded_volume2.setText(stringAns);
        }
    }

    public void update_modified_loaded_volume1() {
        int inputNumber = 3;
        View[] views = {loaded_volume1,
                correction_factor,
                factor_of_inclination
        };
        String[] defaults = {"410.7923", "0.9", "0.98"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            doubleAns = doubleValues[0] * doubleValues[1] * doubleValues[2];
            stringAns = String.valueOf(doubleAns);
            modified_loaded_volume1.setText(stringAns);
        }
    }

    public void update_correction_factor() {
        int inputNumber = 1;
        View[] views = {feed1};
        String[] defaults = {"3"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            if (stringValues[0].equals("1")) {
                stringAns = "1";
            } else if (stringValues[0].equals("2")) {
                stringAns = "0.95";
            } else if (stringValues[0].equals("3")) {
                stringAns = "0.9";
            } else {
                stringAns = String.valueOf(false);
            }

            correction_factor.setText(stringAns);
        }
    }

    public void update_loaded_volume1() {
        int inputNumber = 4;
        View[] views = {loaded_volume,
                v_max_from_table,
                factor_of_inclination,
                correction_factor
        };
        String[] defaults = {"833.333", "2.3", "0.98", "0.9"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                }
                if (text.isEmpty()) {
                    stringValues[i] = defaults[i];

                } else {
                    stringValues[i] = text;
                }
                if (checkDouble(stringValues[i])) {
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            doubleAns = doubleValues[0] / (doubleValues[1] * doubleValues[2] * doubleValues[3]);


            stringAns = String.valueOf(doubleAns);
            loaded_volume1.setText(stringAns);
        }

    }

    public void update_loaded_volume() {

        int inputNumber = 2;
        View[] views = {load_capacity_of_the_belt_final,
                specific_weight};
        String[] defaults = {"1000", "1.2"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {
            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                Log.d("TAG", "i = " + i);
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                    Log.d("TAG", "views[i] is edit text");
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                    Log.d("TAG", "views[i] is text view");
                }
                Log.d("TAG", "views[i] text = " + text);
                if (text.isEmpty()) {
                    Log.d("TAG", "views[i] text is empty so it must replace with default value");
                    Log.d("TAG", "views[i] default value = " + defaults[i]);
                    stringValues[i] = defaults[i];
                    Log.d("TAG", "now the value must be change to string value[i] = " + stringValues[i]);

                } else {
                    stringValues[i] = text;
                    Log.d("TAG", "views[i] text is not empty and the value is = " + stringValues[i]);
                }
                if (checkDouble(stringValues[i])) {
                    Log.d("TAG", "value is double so I put it in the doubleValues");
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                    Log.d("TAG", "doubleValue[i] = " + doubleValues[i]);
                }
            }
            String stringAns;
            double doubleAns;

            //now play with values:
            doubleAns = doubleValues[0] / doubleValues[1];
            stringAns = String.valueOf(doubleAns);


            loaded_volume.setText(stringAns);
        }

    }

    public void update_roll_troughing_sets() {
        int inputNumber = 1;
        View[] views = {design_of_the_troughing_sets};
        String[] defaults = {"4"};
        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {

            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                Log.d("TAG", "i = " + i);
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                    Log.d("TAG", "views[i] is edit text");
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                    Log.d("TAG", "views[i] is text view");
                }
                Log.d("TAG", "views[i] text = " + text);
                if (text.isEmpty()) {
                    Log.d("TAG", "views[i] text is empty so it must replace with default value");
                    Log.d("TAG", "views[i] default value = " + defaults[i]);
                    stringValues[i] = defaults[i];
                    Log.d("TAG", "now the value must be change to string value[i] = " + stringValues[i]);

                } else {
                    stringValues[i] = text;
                    Log.d("TAG", "views[i] text is not empty and the value is = " + stringValues[i]);
                }
                if (checkDouble(stringValues[i])) {
                    Log.d("TAG", "value is double so I put it in the doubleValues");
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                    Log.d("TAG", "doubleValue[i] = " + doubleValues[i]);
                }
            }

            //now work with values
            String stringAns;
            switch (stringValues[0]) {
                case "1":
                    stringAns = "flat roller set";
                    break;
                case "2":
                    stringAns = "2 roller troughing sets";
                    break;
                case "3":
                    stringAns = "3 roll troughing sets";
                    break;
                case "4":
                    stringAns = "roll troughing sets";
                    break;
                default:
                    stringAns = "false";
            }
            roll_troughing_sets.setText(stringAns);
        }
    }

    public void update_load_capacity_of_the_belt_final() {

        int inputNumber = 2;
        View[] views = {load_capacity_of_the_belt,
                load_capacity_of_the_belt_stph};
        String[] defaults = {"1000", "0"};

        if (defaults.length != inputNumber && views.length != inputNumber) {
            Toast.makeText(this, "check default values", Toast.LENGTH_LONG).show();
        } else {

            String[] stringValues = new String[inputNumber];
            double[] doubleValues = new double[inputNumber];

            //if an edit view is empty I'll put default value
            for (int i = 0; i < inputNumber; i++) {
                String text = "";
                Log.d("TAG", "i = " + i);
                if (views[i].getClass().equals(material_edit.getClass())) {
                    EditText view = (EditText) views[i];
                    text = view.getText().toString();
                    Log.d("TAG", "views[i] is edit text");
                } else if (views[i].getClass().equals(load_capacity_of_the_belt_final.getClass())) {
                    TextView view = (TextView) views[i];
                    text = view.getText().toString();
                    Log.d("TAG", "views[i] is text view");
                }
                Log.d("TAG", "views[i] text = " + text);
                if (text.isEmpty()) {
                    Log.d("TAG", "views[i] text is empty so it must replace with default value");
                    Log.d("TAG", "views[i] default value = " + defaults[i]);
                    stringValues[i] = defaults[i];
                    Log.d("TAG", "now the value must be change to string value[i] = " + stringValues[i]);

                } else {
                    stringValues[i] = text;
                    Log.d("TAG", "views[i] text is not empty and the value is = " + stringValues[i]);
                }
                if (checkDouble(stringValues[i])) {
                    Log.d("TAG", "value is double so I put it in the doubleValues");
                    doubleValues[i] = Double.parseDouble(stringValues[i]);
                    Log.d("TAG", "doubleValue[i] = " + doubleValues[i]);
                }
            }

            //now work with values
            String stringAns;
            double doubleAns;
            if (doubleValues[0] > 0) {
                stringAns = stringValues[0];
            } else if (doubleValues[1] > 0) {
                stringAns = String.valueOf(doubleValues[1] * 0.9072);
            } else {
                stringAns = String.valueOf(false);
            }

            load_capacity_of_the_belt_final.setText(stringAns);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        material_edit = findViewById(R.id.material_edit);
        angle_of_surcharge = findViewById(R.id.angle_of_surcharge);
        angle_of_repose = findViewById(R.id.angle_of_repose);
        lump_size = findViewById(R.id.lump_size);
        specific_weight = findViewById(R.id.specific_weight);
        abrasiveness = findViewById(R.id.abrasiveness);
        corrosiveness = findViewById(R.id.corrosiveness);
        physical_characteristics = findViewById(R.id.physical_characteristics);
        v_max_from_table = findViewById(R.id.v_max_from_table);
        v_max_desired = findViewById(R.id.v_max_desired);
        load_capacity_of_the_belt = findViewById(R.id.load_capacity_of_the_belt);
        load_capacity_of_the_belt_stph = findViewById(R.id.load_capacity_of_the_belt_stph);
        lambda = findViewById(R.id.lambda);
        design_of_the_troughing_sets = findViewById(R.id.design_of_the_troughing_sets);
        loaded_volume2 = findViewById(R.id.loaded_volume2);
        inclination = findViewById(R.id.inclination);
        factor_of_inclination = findViewById(R.id.factor_of_inclination);
        feed1 = findViewById(R.id.feed1);
        feed2 = findViewById(R.id.feed2);
        feed3 = findViewById(R.id.feed3);
        feed4 = findViewById(R.id.feed4);
        editTextNumberDecimal = findViewById(R.id.breaking_load);
        belt_width = findViewById(R.id.belt_width);
        min_belt_width = findViewById(R.id.min_belt_width);
        belt_width2 = findViewById(R.id.belt_width2);
        impact_factor = findViewById(R.id.impact_factor);
        utilisation = findViewById(R.id.utilisation);
        service_factor = findViewById(R.id.service_factor);
        environment_factor = findViewById(R.id.environment_factor);
        participation_factor_in_upper = findViewById(R.id.participation_factor_in_upper);
        speed_factor = findViewById(R.id.speed_factor);
        return_troughing_set_with_a_transom_side_roller_angle = findViewById(R.id.return_troughing_set_with_a_transom_side_roller_angle);
        participation_factor_in_return = findViewById(R.id.participation_factor_in_return);
        diameter_of_rollers = findViewById(R.id.diameter_of_rollers);
        belt_kind = findViewById(R.id.belt_kind);
        textile_core_EP = findViewById(R.id.textile_core_EP);
        steel_core_ST = findViewById(R.id.steel_core_ST);
        Belt_core_weight = findViewById(R.id.Belt_core_weight);
        thickness_of_belt = findViewById(R.id.thickness_of_belt);
        working_condition = findViewById(R.id.working_condition);
        Coefficient_of_internal_friction = findViewById(R.id.Coefficient_of_internal_friction);
        Coefficient_of_fixed_resistance = findViewById(R.id.Coefficient_of_fixed_resistance);
        temperature = findViewById(R.id.temperature);
        Coefficient_of_passive_resistance = findViewById(R.id.Coefficient_of_passive_resistance);
        Maximum_advised_pitch_of_troughing_sets = findViewById(R.id.Maximum_advised_pitch_of_troughing_sets);
        weight_of_upper_rotating = findViewById(R.id.weight_of_upper_rotating);
        weight_of_lower_rotating = findViewById(R.id.weight_of_lower_rotating);
        Height_change_of_belt = findViewById(R.id.Height_change_of_belt);
        center_to_center = findViewById(R.id.center_to_center);
        efficiency_of_the_reduction = findViewById(R.id.efficiency_of_the_reduction);


        load_capacity_of_the_belt_final = findViewById(R.id.load_capacity_of_the_belt_final);
        loaded_volume = findViewById(R.id.loaded_volume);
        roll_troughing_sets = findViewById(R.id.roll_troughing_sets);
        loaded_volume1 = findViewById(R.id.loaded_volume1);
        correction_factor = findViewById(R.id.correction_factor);
        modified_loaded_volume1 = findViewById(R.id.modified_loaded_volume1);
        modified_loaded_volume2 = findViewById(R.id.modified_loaded_volume2);
        static_load = findViewById(R.id.static_load);
        dynamic_load = findViewById(R.id.dynamic_load);
        load_on_the_roller_carrying_the_most_force = findViewById(R.id.load_on_the_roller_carrying_the_most_force);
        static_load_on_the_return_roller_set = findViewById(R.id.static_load_on_the_return_roller_set);
        dynamic_load_on_the_return_roller_set = findViewById(R.id.dynamic_load_on_the_return_roller_set);
        load_on_the_rollers_of_the_return_roller_set = findViewById(R.id.load_on_the_rollers_of_the_return_roller_set);
        Belt_weight_per_linear_metre = findViewById(R.id.Belt_weight_per_linear_metre);
        Weight_of_upper_rotating_parts = findViewById(R.id.Weight_of_upper_rotating_parts);
        Weight_of_lower_rotating_parts = findViewById(R.id.Weight_of_lower_rotating_parts);
        Weight_material_per_linear_metre = findViewById(R.id.Weight_material_per_linear_metre);
        rise_or_fall = findViewById(R.id.rise_or_fall);
        tangential_force_of_the_belt_upper_strand = findViewById(R.id.tangential_force_of_the_belt_upper_strand);
        tangential_force_of_the_belt_lower_strand = findViewById(R.id.tangential_force_of_the_belt_lower_strand);
        Tangential_force = findViewById(R.id.Tangential_force);
        Driving_power = findViewById(R.id.Driving_power);


        tab1 = findViewById(R.id.tab1);
        tab2 = findViewById(R.id.tab2);
        physical_characteristics_button = findViewById(R.id.physical_characteristics_button);
        tab3 = findViewById(R.id.tab3);
        roller_button = findViewById(R.id.roller_button);
        fig8 = findViewById(R.id.fig8);
        tab4 = findViewById(R.id.tab4);
        tab5 = findViewById(R.id.tab5);
        tab20 = findViewById(R.id.tab20);
        tab19 = findViewById(R.id.tab19);
        tab17 = findViewById(R.id.tab17);
        tab21 = findViewById(R.id.tab21);
        tab16 = findViewById(R.id.tab16);
        tab10 = findViewById(R.id.tab10);
        tab9 = findViewById(R.id.tab9);
        tab7 = findViewById(R.id.tab7);
        tab8 = findViewById(R.id.tab8);
        tab11 = findViewById(R.id.tab11);
        tab18 = findViewById(R.id.tab18);


        material_edit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
            }
        });

        angle_of_surcharge.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        angle_of_repose.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        lump_size.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        specific_weight.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_loaded_volume();
            }
        });

        abrasiveness.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        corrosiveness.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        physical_characteristics.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        v_max_from_table.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_loaded_volume1();
                update_static_load();
                update_Weight_material_per_linear_metre();
                update_Driving_power();
            }
        });

        v_max_desired.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        load_capacity_of_the_belt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_load_capacity_of_the_belt_final();
                update_Weight_material_per_linear_metre();
            }
        });

        load_capacity_of_the_belt_stph.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_load_capacity_of_the_belt_final();
            }
        });

        lambda.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        design_of_the_troughing_sets.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_roll_troughing_sets();
            }
        });

        loaded_volume2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        inclination.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        factor_of_inclination.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_loaded_volume1();
                update_modified_loaded_volume1();
                update_modified_loaded_volume2();
            }
        });

        feed1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_correction_factor();
            }
        });

        feed2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        feed3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        feed4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        belt_width.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        belt_width2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        impact_factor.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_dynamic_load();
            }
        });


        utilisation.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        service_factor.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_dynamic_load();
                update_dynamic_load_on_the_return_roller_set();
            }
        });

        environment_factor.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_dynamic_load();
                update_dynamic_load_on_the_return_roller_set();
            }
        });

        participation_factor_in_upper.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_load_on_the_roller_carrying_the_most_force();
            }
        });

        speed_factor.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_dynamic_load_on_the_return_roller_set();
            }
        });

        return_troughing_set_with_a_transom_side_roller_angle.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        participation_factor_in_return.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_load_on_the_rollers_of_the_return_roller_set();
            }
        });

        diameter_of_rollers.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        belt_kind.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        textile_core_EP.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        steel_core_ST.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        Belt_core_weight.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_Belt_weight_per_linear_metre();
            }
        });

        thickness_of_belt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_Belt_weight_per_linear_metre();
            }
        });

        working_condition.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        Coefficient_of_internal_friction.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_tangential_force_of_the_belt_upper_strand();
                update_tangential_force_of_the_belt_lower_strand();
            }
        });

        Coefficient_of_fixed_resistance.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_tangential_force_of_the_belt_upper_strand();
                update_tangential_force_of_the_belt_lower_strand();
            }
        });

        temperature.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        Coefficient_of_passive_resistance.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_tangential_force_of_the_belt_upper_strand();
                update_tangential_force_of_the_belt_lower_strand();
            }
        });

        Maximum_advised_pitch_of_troughing_sets.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        weight_of_upper_rotating.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_Weight_of_upper_rotating_parts();
            }
        });

        weight_of_lower_rotating.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_Weight_of_lower_rotating_parts();
            }
        });

        Height_change_of_belt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_rise_or_fall();
                update_tangential_force_of_the_belt_upper_strand();
                update_tangential_force_of_the_belt_lower_strand();
            }
        });

        center_to_center.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_tangential_force_of_the_belt_upper_strand();
                update_tangential_force_of_the_belt_lower_strand();
            }
        });

        efficiency_of_the_reduction.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                update_Driving_power();
            }
        });


        clickToOpenPdf(tab1, "tab-1.pdf");

        clickToOpenPdf(tab2, "tab-2.pdf");

        clickToOpenPdf(tab3, "tab-3.pdf");

        clickToOpenPdf(tab4, "tab-4.pdf");

        clickToOpenPdf(tab5, "tab-5.pdf");

        clickToOpenPdf(tab7, "tab-7.pdf");

        clickToOpenPdf(tab8, "tab-8.pdf");

        clickToOpenPdf(tab9, "tab-9.pdf");

        clickToOpenPdf(tab10, "tab-10.pdf");

        clickToOpenPdf(tab11, "tab-11.pdf");

        clickToOpenPdf(tab16, "tab-16.pdf");

        clickToOpenPdf(tab17, "tab-17.pdf");

        clickToOpenPdf(tab18, "tab-18.pdf");

        clickToOpenPdf(tab19, "tab-19.pdf");

        clickToOpenPdf(tab20, "tab-20.pdf");

        clickToOpenPdf(tab21, "tab-21.pdf");

        clickToOpenPdf(fig8, "fig-8.pdf");

        clickToOpenPdf(roller_button, "roler_set.pdf");

        clickToOpenPdf(physical_characteristics_button, "physical_properties.pdf");

        Tangential_force.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                update_Driving_power();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        tangential_force_of_the_belt_lower_strand.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update_Tangential_force();
            }
        });
        tangential_force_of_the_belt_upper_strand.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update_Tangential_force();
            }
        });

        Weight_of_lower_rotating_parts.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update_tangential_force_of_the_belt_lower_strand();
            }
        });
        Weight_of_upper_rotating_parts.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update_tangential_force_of_the_belt_upper_strand();
                update_tangential_force_of_the_belt_lower_strand();
            }
        });
        Weight_material_per_linear_metre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update_tangential_force_of_the_belt_upper_strand();
            }
        });

        dynamic_load_on_the_return_roller_set.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update_load_on_the_rollers_of_the_return_roller_set();
            }
        });
        static_load_on_the_return_roller_set.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update_dynamic_load_on_the_return_roller_set();
            }
        });
        dynamic_load.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update_load_on_the_roller_carrying_the_most_force();
            }
        });

        static_load.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update_dynamic_load();
            }
        });
        Belt_weight_per_linear_metre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update_static_load();
                update_static_load_on_the_return_roller_set();
                update_tangential_force_of_the_belt_upper_strand();
                update_tangential_force_of_the_belt_lower_strand();
            }
        });
        loaded_volume1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update_modified_loaded_volume1();
                update_modified_loaded_volume2();
            }
        });
        correction_factor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update_loaded_volume1();
                update_modified_loaded_volume1();
                update_modified_loaded_volume2();
            }
        });
        load_capacity_of_the_belt_final.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update_loaded_volume();
                update_static_load();
            }
        });

        loaded_volume.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update_loaded_volume1();
            }
        });
    }

    private void clickToOpenPdf(Button button, final String pdfName) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPdf(pdfName);

            }

        });
    }

    private void openPdf(String pdfName) {
        Uri uri = Uri.parse(FileProvider.CONTENT_URI + pdfName);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}