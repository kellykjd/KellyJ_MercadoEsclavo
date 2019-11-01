package com.example.recyclermercadoabierto.model;

import com.example.recyclermercadoabierto.R;
import com.example.recyclermercadoabierto.ResultListener;

import java.util.ArrayList;
import java.util.List;

public class ProductoDao {

    public void traerProductos(ResultListener<List<Producto>> listenerDelController){
        List<Producto> productos= new ArrayList<>();
        productos.add(new Producto("Gazebo","GAZEBO PLEGABLE AUTOARMABLE MODELO REFORZADO UNIONES METALICAS - IMPERMEABLE\n" +
                "Gazebo Autoarmable 3x3\n" +
                "\n" +
                "Características\n" +
                "Modelo 3x3\n" +
                "Largo 300 cm\n" +
                "Ancho 300 cm\n" +
                "Material de la tela: OXFORD POLYESTER 210D\n" +
                "Recubrimiento de PVC (Evita el daño del tejido por radiacion solar UV e impermiabiliza la superficie)\n" +
                "· Tubos estructurales exteriores: 30 mm x 30 mm x 0.6 mm de espesor\n" +
                "· Tubos estructurales inferiores: 25 mm x 25 mm x 0.6 mm de espesor\n" +
                "· Tubos estructurales transversales: 25 mm x 14 mm x 0.6 mm de espesor\n" +
                "· Peso de la estructura sola: 12 kg\n" +
                "· Peso completo: 15 kg\n" +
                ". Laterales: opcionales (no incluidos)\n" +
                "· Dimensiones de la caja: 147 cm x 19.5 cm x 19.5 cm","$5.499",R.drawable.gazebo));
		        productos.add(new Producto("Notebook Dell Inspiron I3","Display 14.0-inch HD (1366 x 768) Anti-Glare LED-Backlit Non-touch Display\n" +
                "Processor 7th Generation Intel® Core¿ i3-7020U Processor (3MB Cache, 2.30 GHz) [GI8D3ON]\n" +
                "Primary Battery 42WHr, 3-Cell Battery (Integrated) [G728WKV]\n" +
                "Memory 8GB (4Gx2) DDR4 (Expandible)\n" +
                "Power 45W AC Adapter, 3Pin\n" +
                "Operating System Windows 10 Home\n" +
                "Warranty 1 Year Carry-In Service [LCI1]\n" +
                "Modelo Inspiron 14 3000 - 3481\n" +
                "UPC 884116336822\n" +
                "Bluetooth 802.11ac 1x1 WiFi and Bluetooth [GQXN6CZ]\n" +
                "Keyboard Standard Keyboard Spanish\n" +
                "Mouse No Mouse\n" +
                "Primary Optical Device No ODD\n" +
                "Primary Storage 1TB 5400 rpm 2.5 SATA Hard Drive [GAZBJH9]\n" +
                "Antivirus McAfee CB LiveSafe 15 mon subscription\n" +
                "Color Platinum Silver\n" +
                "Bluetooth Bluetooth [GQXN6CZ]\n" +
                "Wireless Driver 802.11ac 1x1 WiFi and Bluetooth [GQXN6CZ]\n" +
                "Wireless Wan card 802.11ac 1x1 WiFi and Bluetooth [GQXN6CZ]\n" +
                "FGA SKU MOD 998-DKRL\n" +
                "Garantía Oficial del Fabricante: 12 meses.","$45.399",R.drawable.notebook));
        productos.add(new Producto("Mochila Porta Bebe Carestino 3 En 1","La mochila portabebé 3 en 1 Carestino ofrece el cuidado y la seguridad necesarios para llevar a tu bebé fácilmente, adaptándose a 3 posiciones: De frente, posición lateral con apoyo natural en la cadera, y en la espalda para que pueda explorar libremente. El bebé se apoya en una posición natural con sus rodillas ligeramente por encima de sus caderas, favoreciendo el desarrollo saludable de cadera y columna vertebral.\n" +
                "\n" +
                "La posición lateral utiliza de soporte la forma natural del cuerpo para estabilizar y llevar el peso del bebé uniforme. La capucha ajustable ofrece protección solar para el bebé y brinda privacidad mientras amamanta. Las correas de seguridad se pueden acortar o ajustar hacia arriba o hacia abajo para garantizar un ajuste cómodo. El bolsillo frontal con cierre ofrece un práctico almacenamiento.\n" +
                "\n" +
                "ESPECIFICACIONES TÉCNICAS\n" +
                "\n" +
                "PESO 0,6 Kg.\n" +
                "\n" +
                "SOPORTA hasta 15 Kg.\n" +
                "\n" +
                "MEDIDA 49 * 35 cm.\n" +
                "\n" +
                "RECOMENDADO Desde que el bebé se sienta solo (6 meses) y hasta 15 Kg.","$2.499",R.drawable.mochila));
        productos.add(new Producto("Cinta de correr Eléctrica World Fitness DX-25","Potenciá tu entrenamiento\n" +
                "Con su motor eléctrico, la cinta funcionará al ritmo que definas. Calentá, caminá y corré a la velocidad que te propongas, ¡alcanzá todos tus objetivos!\n" +
                "\n" +
                "Prevení lesiones\n" +
                "Su excelente amortiguación te ayudará a proteger articulaciones, músculos y ligamentos en cada paso. Entrená tu cuerpo y resguardá tu salud siempre.\n" +
                "\n" +
                "Programas para optimizar tu rutina\n" +
                "Animate a usar los programas preestablecidos. Ejercitá de manera aeróbica, fortalecé tu resistencia y mejorá tu estado físico.\n" +
                "\n" +
                "Práctica y cómoda\n" +
                "Gracias a su diseño plegable, podrás trasladarla y guardarla en cualquier rincón sin ninguna dificultad.\n" +
                "\n" +
                "Controlá tu rutina\n" +
                "Cuenta con un diseño moderno y una pantalla digital, en la cual podrás visualizar los avances de tu entrenamiento y controlar tus progresos.\n" +
                "\n" +
                "Atrevete a más\n" +
                "Su potencia y su velocidad te permitirán iniciarte en el camino de alcanzar los objetivos propuestos, superarte e ir por más.","$28.500",R.drawable.cinta));
        productos.add(new Producto("Cubre Amortiguador Neoprene Honda C/cierre + Cubre Calzado","Combo Juego de 2 Cubre Amortiguadores Modelo Mosnter RockStar Honda Yamaha Suzuki Rouser. Opciones en Colores Fuertes y Nitidos. Incluye Cubre Palancas De cambios de regalo- Confeccionados en Tela Neoprene Premium Quality.\n" +
                "Disponible Para Motos CG YBR ROUSER EN etc etc.","$440",R.drawable.cubreamortiguador));
        productos.add(new Producto("Estante fotos cuadro, flotante 4cmX1m","* Estructura: Madera Paraíso enchapado\n" +
                "* Medida publicada: 1m de largo\n" +
                "* Medida de base: 4cm útiles\n" +
                "* Medida de trasero: 8cm de alto\n" +
                "* Terminación: Laca poliurétanica al agua - Las lacas al agua protegen la madera pero no le dan ninguna terminacion en la textura del mismo.\n" +
                "* Detalles: Incluye tornillos y tarugos para colgar","$700",R.drawable.estante));
        productos.add(new Producto("Microondas BGH Quick Chef B120DE Blanco","Variedad de funciones y programas\n" +
                "Posee la función de descongelamiento automático, que calcula el tiempo necesario y la potencia según el tipo de alimento o según el peso. Para destacar, este microondas cuenta con diferentes niveles de cocción y 6 programas, lo que te posibilitará disfrutar todas tus comidas con mínimo esfuerzo y máximo sabor.\n" +
                "\n" +
                "Diseño innovador y accesorios\n" +
                "Su display te permitirá ser más preciso al momento de seleccionar el tipo de comida, configurar el tiempo y la función para cocinar. A su vez, cuenta con un plato giratorio para cocinar o calentar los alimentos uniformemente en el menor tiempo posible. Además, presenta un excelente sistema de seguridad, con una traba especial, para cuidar a los más pequeños de la familia.\n" +
                "\n" +
                "Capacidad y eficiencia\n" +
                "Con un volumen de 20 litros, podrás disfrutar comidas para compartir con amigos y familia. Ofrece una potencia máxima de 700 watts, que se puede regular en diferentes niveles según el tipo de alimento, por ejemplo, para evitar que se resequen algunos platos más delicados como la pasta. Asimismo, este producto se destaca por su bajo consumo, que contribuye al ahorro energético del hogar. Con su fácil uso, podrás seleccionar y programar de manera práctica el tipo de comida que desees calentar para personalizar tus platos preferidos.","$7.699",R.drawable.microondas));

        listenerDelController.finish(productos);
    }
}
