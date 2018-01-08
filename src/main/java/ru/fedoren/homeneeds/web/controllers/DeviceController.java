package ru.fedoren.homeneeds.web.controllers;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import ru.fedoren.homeneeds.core.models.Device;
import ru.fedoren.homeneeds.core.repositories.device.DeviceRepository;

@Controller
@RequestMapping("/device")
public class DeviceController {
  private DeviceRepository deviceRepository;

  @Autowired
  public DeviceController(final DeviceRepository deviceRepository) {
    this.deviceRepository = deviceRepository;
  }

  /**
   * Create new device.
   * @param newDevice object for creating
   * @return created object
   */
  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<Device> create(@RequestBody Device newDevice) {
    Device createdDevice = deviceRepository.addNewDevice(newDevice);
    URI location = UriComponentsBuilder.fromPath("/device/")
        .path(String.valueOf(createdDevice.getId()))
        .build().toUri();
    return ResponseEntity.created(location).body(createdDevice);
  }

  /**
   * Get device by id.
   * @param id od device
   * @return found device
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<Device> getById(@PathVariable String id) {
    Device foundDevice = deviceRepository.getDeviceById(Long.valueOf(id));
    URI location = UriComponentsBuilder.fromPath("/device/")
        .path(String.valueOf(foundDevice.getId()))
        .build().toUri();
    return ResponseEntity.created(location).body(foundDevice);
  }

  /**
   * Update device.
   * @param newDevice object for updating
   * @return updated object
   */
  @RequestMapping(method = RequestMethod.PUT)
  @ResponseBody
  public ResponseEntity<Device> update(@RequestBody Device newDevice) {
    Device createdDevice = deviceRepository.updateDevice(newDevice);
    URI location = UriComponentsBuilder.fromPath("/device/")
        .path(String.valueOf(createdDevice.getId()))
        .build().toUri();
    return ResponseEntity.created(location).body(createdDevice);
  }

  /**
   * Delete device.
   * @return result of deleting
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity delete(@PathVariable String id) {
    boolean resultOfDeleting = deviceRepository.deleteDevice(Long.valueOf(id));
    URI location = UriComponentsBuilder.fromPath("/device/")
        .path(String.valueOf(resultOfDeleting))
        .build().toUri();
    return ResponseEntity.created(location).body(resultOfDeleting);
  }
}
