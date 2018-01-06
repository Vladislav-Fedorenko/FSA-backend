package topLevelDomain.secondLevelDomain.homeneeds.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

import topLevelDomain.secondLevelDomain.homeneeds.core.models.Device;
import topLevelDomain.secondLevelDomain.homeneeds.core.repositories.device.DeviceRepository;

@Controller
@RequestMapping("/device")
public class DeviceController {
  private DeviceRepository deviceRepository;

  @Autowired
  public DeviceController(final DeviceRepository deviceRepository) {
    this.deviceRepository = deviceRepository;
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<Device> create(@RequestBody Device newDevice) {
    Device createdDevice = deviceRepository.addNewDevice(newDevice);
    URI location = UriComponentsBuilder.fromPath("/device/")
      .path(String.valueOf(createdDevice.getId()))
      .build().toUri();
    return ResponseEntity.created(location).body(createdDevice);
  }

  @RequestMapping(method = RequestMethod.PUT)
  @ResponseBody
  public ResponseEntity<Device> update(@RequestBody Device newDevice) {
    Device createdDevice = deviceRepository.updateDevice(newDevice);
    URI location = UriComponentsBuilder.fromPath("/device/")
      .path(String.valueOf(createdDevice.getId()))
      .build().toUri();
    return ResponseEntity.created(location).body(createdDevice);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity delete(@PathVariable String id) {
    boolean resultOfDeleting = deviceRepository.deleteDevice(Long.valueOf(id));
    URI location = UriComponentsBuilder.fromPath("/device/")
      .path(String.valueOf(resultOfDeleting))
      .build().toUri();
    return ResponseEntity.created(location).body(resultOfDeleting);
  }
}
