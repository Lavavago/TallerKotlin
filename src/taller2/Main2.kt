package taller2

import java.time.Year

fun main() {
    val direccionHospital = Direccion("Calle 100", "25", "La Colina", "Bogotá", "110111")
    val hospital = Hospital("Clínica del Bienestar", "900.123.456-7", direccionHospital)
    println("--- Sistema de Gestión Hospitalaria ---")
    println("El sistema se ha iniciado sin datos de prueba. Por favor, agregue médicos y pacientes desde el menú.")

    while (true) {
        mostrarMenu()
        when (val opcion = readlnOrNull()?.toIntOrNull()) {
            1 -> crearMedico(hospital)
            2 -> verMedicos(hospital)
            3 -> actualizarMedico(hospital)
            4 -> eliminarMedico(hospital)
            5 -> crearPaciente(hospital)
            6 -> verPacientes(hospital)
            7 -> actualizarPaciente(hospital)
            8 -> eliminarPaciente(hospital)
            9 -> mostrarEstadisticas(hospital)
            10 -> {
                println("Salida ")
                return
            }
            else -> println("Inténtelo de nuevo")
        }
    }
}


//////////////////////////////////////////// menu/////////////////////////////////////////////

fun mostrarMenu() {
    println("\n--- Menú Principal ---")
    println("1. Crear Médico")
    println("2. Ver Médico por ID")
    println("3. Actualizar Médico")
    println("4. Eliminar Médico")
    println("5. Crear Paciente")
    println("6. Ver Paciente por ID")
    println("7. Actualizar Paciente")
    println("8. Eliminar Paciente")
    println("9. Ver estadísticas del hospital")
    println("10. Salir")
    print("Seleccione una opción: ")
}


//////////////////////////////////////////// CRUD /////////////////////////////////////////////


fun crearMedico(hospital: Hospital) {
    println("\nCreación de Médico ")
    print("Nombre completo: ")
    val nombre = readln()
    print("Número de identificación: ")
    val id = readln()
    print("Género: ")
    val genero = readln()
    print("Correo electrónico: ")
    val correo = readln()
    print("Número de licencia: ")
    val licencia = readln()
    print("Especialidad: ")
    val especialidad = readln()
    print("Año de ingreso: ")
    val anioIngreso = readln().toIntOrNull() ?: Year.now().value

    val nuevoMedico = Medico(nombre, id, genero, correo, licencia, especialidad, anioIngreso)
    hospital.agregarMedico(nuevoMedico)
}

fun verMedicos(hospital: Hospital) {
    print("\n Ver Médico \nIngrese el ID del médico: ")
    val id = readln()
    val medico = hospital.obtenerMedico(id)
    if (medico != null) {
        println(medico)
    } else {
        println("Médico no encontrado.")
    }
}

fun actualizarMedico(hospital: Hospital) {
    print("\n  Actualizar Médico \nIngrese el ID del médico a actualizar: ")
    val id = readln()
    val medicoExistente = hospital.obtenerMedico(id)
    if (medicoExistente == null) {
        println("Médico no encontrado.")
        return
    }

    println("Ingrese los nuevos datos lo pudes dejar en blanco para no cambiar:")
    print("Nombre completo (${medicoExistente.nombreCompleto}): ")
    val nombre = readln().takeIf { it.isNotBlank() } ?: medicoExistente.nombreCompleto
    print("Género (${medicoExistente.genero}): ")
    val genero = readln().takeIf { it.isNotBlank() } ?: medicoExistente.genero
    print("Correo electrónico (${medicoExistente.correoElectronico}): ")
    val correo = readln().takeIf { it.isNotBlank() } ?: medicoExistente.correoElectronico
    print("Número de licencia (${medicoExistente.numeroLicencia}): ")
    val licencia = readln().takeIf { it.isNotBlank() } ?: medicoExistente.numeroLicencia
    print("Especialidad (${medicoExistente.especialidad}): ")
    val especialidad = readln().takeIf { it.isNotBlank() } ?: medicoExistente.especialidad
    print("Año de ingreso (${medicoExistente.anioIngreso}): ")
    val anioIngreso = readln().toIntOrNull() ?: medicoExistente.anioIngreso

    val medicoActualizado = Medico(nombre, medicoExistente.numeroIdentificacion, genero, correo, licencia, especialidad, anioIngreso)
    hospital.actualizarMedico(id, medicoActualizado)
}

fun eliminarMedico(hospital: Hospital) {
    print("\nEliminar Médico \nIngrese el ID del médico a eliminar: ")
    val id = readln()
    hospital.eliminarMedico(id)
}

fun crearPaciente(hospital: Hospital) {
    println("\nCreación de Paciente ")
    print("Nombre completo: ")
    val nombre = readln()
    print("Número de identificación: ")
    val id = readln()
    print("Género: ")
    val genero = readln()
    print("Correo electrónico: ")
    val correo = readln()
    print("Teléfono de contacto: ")
    val telefono = readln()

    println(" Dirección ")
    print("Calle: ")
    val calle = readln()
    print("Número: ")
    val numero = readln()
    print("Barrio: ")
    val barrio = readln()
    print("Ciudad: ")
    val ciudad = readln()
    print("Código Postal: ")
    val codigoPostal = readln()

    val direccion = Direccion(calle, numero, barrio, ciudad, codigoPostal)
    val nuevoPaciente = Paciente(nombre, id, genero, correo, telefono, direccion)
    hospital.agregarPaciente(nuevoPaciente)
}

fun verPacientes(hospital: Hospital) {
    print("\nVer Paciente \nIngrese el ID del paciente: ")
    val id = readln()
    val paciente = hospital.obtenerPaciente(id)
    if (paciente != null) {
        println(paciente)
    } else {
        println("Paciente no encontrado.")
    }
}

fun actualizarPaciente(hospital: Hospital) {
    print("\n Actualizar Paciente \nIngrese el ID del paciente a actualizar: ")
    val id = readln()
    val pacienteExistente = hospital.obtenerPaciente(id)
    if (pacienteExistente == null) {
        println("Paciente no encontrado.")
        return
    }

    println("Ingrese los nuevos datos deje en blanco para no cambiar:")
    print("Nombre completo (${pacienteExistente.nombreCompleto}): ")
    val nombre = readln().takeIf { it.isNotBlank() } ?: pacienteExistente.nombreCompleto
    print("Género (${pacienteExistente.genero}): ")
    val genero = readln().takeIf { it.isNotBlank() } ?: pacienteExistente.genero
    print("Correo electrónico (${pacienteExistente.correoElectronico}): ")
    val correo = readln().takeIf { it.isNotBlank() } ?: pacienteExistente.correoElectronico
    print("Teléfono de contacto (${pacienteExistente.telefono}): ")
    val telefono = readln().takeIf { it.isNotBlank() } ?: pacienteExistente.telefono

    println("  Dirección deje en blanco para no cambiar ")
    print("Calle (${pacienteExistente.direccion.calle}): ")
    val calle = readln().takeIf { it.isNotBlank() } ?: pacienteExistente.direccion.calle
    print("Número (${pacienteExistente.direccion.numero}): ")
    val numero = readln().takeIf { it.isNotBlank() } ?: pacienteExistente.direccion.numero
    print("Barrio (${pacienteExistente.direccion.barrio}): ")
    val barrio = readln().takeIf { it.isNotBlank() } ?: pacienteExistente.direccion.barrio
    print("Ciudad (${pacienteExistente.direccion.ciudad}): ")
    val ciudad = readln().takeIf { it.isNotBlank() } ?: pacienteExistente.direccion.ciudad
    print("Código Postal (${pacienteExistente.direccion.codigoPostal}): ")
    val codigoPostal = readln().takeIf { it.isNotBlank() } ?: pacienteExistente.direccion.codigoPostal

    val nuevaDireccion = Direccion(calle, numero, barrio, ciudad, codigoPostal)
    val pacienteActualizado = Paciente(nombre, pacienteExistente.numeroIdentificacion, genero, correo, telefono, nuevaDireccion)
    hospital.actualizarPaciente(id, pacienteActualizado)
}

fun eliminarPaciente(hospital: Hospital) {
    print("\n Eliminar Paciente  \nIngrese el ID del paciente a eliminar: ")
    val id = readln()
    hospital.eliminarPaciente(id)
}



//////////////////////////////////////////// Estadistica,calcula salario,porcentaje pacientes genero,cantidad medicos,año antiguedad /////////////////////////////////////////////


fun mostrarEstadisticas(hospital: Hospital) {
    println("\n Estadísticas del Hospital ")
    println("Salario total de todos los médicos: ${String.format("%,.2f", hospital.calcularSalarioTotal())} COP")
    println("Salario total por especialidad: ${hospital.calcularSalarioPorEspecialidad()}")
    println("Porcentaje de pacientes por género: ${hospital.obtenerPorcentajePacientesPorGenero()}")
    println("Cantidad de médicos por especialidad: ${hospital.obtenerCantidadMedicosPorEspecialidad()}")

    val medicoAntiguo = hospital.obtenerMedicoMasAntiguo()
    if (medicoAntiguo != null) {
        val aniosAntiguedad = Year.now().value - medicoAntiguo.anioIngreso
        println("Médico con más antigüedad: ${medicoAntiguo.nombreCompleto}, con $aniosAntiguedad años de servicio. Especialidad: ${medicoAntiguo.especialidad}")
    } else {
        println("No hay médicos registrados para calcular la antigüedad.")
    }
}
