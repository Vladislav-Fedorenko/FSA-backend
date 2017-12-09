package topLevelDomain.secondLevelDomain.homeneeds.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;
import topLevelDomain.secondLevelDomain.homeneeds.core.models.Device;
import topLevelDomain.secondLevelDomain.homeneeds.core.repositories.device.DeviceRepository;

import java.net.URI;

@Controller
public class DeviceController {
  private DeviceRepository deviceRepository;

  @Autowired
  public DeviceController(final DeviceRepository deviceRepository) {
    this.deviceRepository = deviceRepository;
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<Device> write(@RequestBody Device newDevice) {
    Device createdDevice = deviceRepository.addNewDevice(newDevice);
    URI location = UriComponentsBuilder.fromPath("/device/")
      .path(String.valueOf(createdDevice.getId()))
      .build().toUri();
    return ResponseEntity.created(location).body(createdDevice);
  }
}
