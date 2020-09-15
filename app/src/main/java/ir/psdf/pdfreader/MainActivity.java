package ir.psdf.pdfreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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


        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "tab-1.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "tab-2.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

        });

        tab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "tab-3.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

        tab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "tab-4.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

        tab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "tab-5.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

        tab7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "tab-7.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

        tab8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "tab-8.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

        tab9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "tab-9.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

        tab10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "tab-10.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

        tab11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "tab-11.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

        tab16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "tab-16.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

        tab17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "tab-17.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

        tab18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "tab-18.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

        tab19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "tab-19.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

        });

        tab20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "tab-20.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

        tab21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "tab-21.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

        fig8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "fig-8.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

        roller_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "roler_set.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });

        physical_characteristics_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(FileProvider.CONTENT_URI + "physical_properties.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });
    }
}