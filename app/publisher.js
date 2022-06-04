import mqtt from 'mqtt';
import {sensorTemperatura} from './sensorTemperatura.js'

const client  = mqtt.connect('mqtt://localhost:1883')
var sensor = new sensorTemperatura();

client.on('connect', function () {
  client.subscribe('sensor', function (err) {
    if (!err) {
        for (let index = 0; index < 10; index++) {
            var pub_message = 'T['+index+']: '+sensor.getTemperatura() + ''
            client.publish('sensor', pub_message)
        }
        
    }
  })
})

client.on('message', function (topic, message) {
  // message is Buffer
  console.log(message.toString())
  client.end()
})